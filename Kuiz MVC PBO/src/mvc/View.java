package mvc;

import java.awt.Color;
import java.sql.Statement;

import static java.awt.SystemColor.window;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    JLabel ljudul, ltipe, lepisode, lgenre, lrating, lstatus;
    JTextField tfjudul, tftipe, tfepisode, tfgenre, tfrating,tfsearch;
    JButton btnRefresh, btnBatal, btnTambah, btnDelete, btnExit, btnSearch;
    String status[] = {"Selesai","Belum"};
    JComboBox<String> cbsatus = new JComboBox<String>(status);
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;  //buat scroll
    Object namaKolom[] = {"#","ID","Judul","Tipe","Episode","Genre","Status","Rating"}; //Membuat kolom dalam Array
    Statement statement;

    public View() {
        setTitle("List Film Terbaru");

        tableModel = new DefaultTableModel(namaKolom, 0); //0 baris
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        ljudul = new JLabel("Judul");
        ltipe = new JLabel("Tipe");
        lepisode = new JLabel("Episode");
        lgenre = new JLabel("Genre");
        lrating = new JLabel("Rating");
        lstatus = new JLabel("Status");

        tfjudul = new JTextField("");
        tftipe = new JTextField("");
        tfepisode = new JTextField("");
        tfrating = new JTextField("");
        tfgenre = new JTextField("");
        tfsearch = new JTextField("");

        btnTambah = new JButton("Tambah");
        btnBatal = new JButton("Batal");
        btnDelete = new JButton("Delete");
        btnRefresh = new JButton("Refresh");
        btnExit = new JButton("Exit");
        btnSearch = new JButton("Search");

        setLayout(null);
        add(ljudul);
        add(ltipe);
        add(lepisode);
        add(lrating);
        add(lgenre);
        add(lstatus);
        add(tfjudul);
        add(tfepisode);
        add(tfgenre);
        add(tfrating);
        add(tftipe);
        add(cbsatus);
        add(btnTambah);
        add(btnBatal);
        add(btnDelete);
        add(btnRefresh);
        add(btnSearch);
        add(tfsearch);
        add(btnExit);
        add(scrollPane);


        ljudul.setBounds(5, 5, 90, 20);
        ltipe.setBounds(5, 30, 90, 20);
        lepisode.setBounds(5, 55, 90, 20);
        lgenre.setBounds(5, 80, 90, 20);
        lrating.setBounds(250, 5, 90, 20);
        lstatus.setBounds(250, 30, 90, 20);
        tfjudul.setBounds(110, 5, 120, 20);
        tftipe.setBounds(110, 30, 120, 20);
        tfepisode.setBounds(110, 55, 120, 20);
        tfgenre.setBounds(110, 80, 120, 20);
        tfrating.setBounds(355, 5, 120, 20);
        cbsatus.setBounds(355, 30, 90, 20);
        tfsearch.setBounds(300, 70, 150, 20);
        btnSearch.setBounds(460, 70, 90, 20);
        btnTambah.setBounds(20, 105, 90, 20);
        btnBatal.setBounds(130, 105, 90, 20);
        btnDelete.setBounds(240, 105, 90, 20);
        btnRefresh.setBounds(350, 105, 90, 20);
        btnExit.setBounds(460, 105, 90, 20);
        scrollPane.setBounds(20, 145, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportBorder(new LineBorder(Color.RED));
        scrollPane.getViewport();

        setVisible(true);
        setLayout(null);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public String getJudul(){
        return tfjudul.getText();
    }

    public String getTipe(){
        return tftipe.getText();
    }

    public String getEpisode(){
        return tfepisode.getText();
    }

    public String getGenre(){
        return tfgenre.getText();
    }

    public String getRating(){
        return tfrating.getText();
    }
}
