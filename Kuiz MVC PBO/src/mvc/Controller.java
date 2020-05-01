package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        if (model.getBanyakData() != 0) {
            String dataFilm[][] = model.readFilm();
            view.tabel.setModel((new JTable(dataFilm, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        view.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = view.getJudul();
                String tipe = view.getTipe();
                String episode = view.getEpisode();
                String genre = view.getGenre();
                String rating = view.getRating();
                String status = (String) view.cbsatus.getSelectedItem();
                model.insertFilm(judul, tipe, episode, genre, rating, status);

                String dataFilm[][] = model.readFilm();
                view.tabel.setModel(new JTable(dataFilm, view.namaKolom).getModel());
            }
        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int baris = view.tabel.getSelectedRow();
                int kolom = view.tabel.getSelectedColumn();

                String dataterpilih = view.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NAMA" + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    model.deleteFilm(dataterpilih);
                    String dataFilm[][] = model.readFilm();
                    view.tabel.setModel(new JTable(dataFilm, view.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

        view.btnRefresh.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = view.getJudul();
                String tipe = view.getTipe();
                String episode = view.getEpisode();
                String genre = view.getGenre();
                String rating = view.getRating();
                String status = (String) view.cbsatus.getSelectedItem();
                model.insertFilm(judul, tipe, episode, genre, rating, status);

                String dataFilm[][] = model.readFilm();
                view.tabel.setModel(new JTable(dataFilm, view.namaKolom).getModel());
            }
        });
    }
}
