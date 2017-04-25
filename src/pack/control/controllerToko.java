/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;

import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.List; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTab;
import javax.swing.table.TableModel;
import pack.dao.daoToko; 
import pack.dao.implementToko; 
import pack.model.m_Toko; 
import pack.view.home; 
import pack.model.tableModelToko; 

/**
 *
 * @author faizaaulia
 */
public class controllerToko {
    
    home hm;;
    implementToko impToko;
    List<m_Toko> lt;
    
    public controllerToko(home hm) {
        this.hm = hm;
        impToko = (implementToko) new daoToko();
        lt = impToko.getAll();
    }
    
    //mengkosongkan isian field
    public void Rest() {
        hm.getTxtKode().setText("");
        hm.getTxtNama().setText("");
        hm.getTxtHarga().setText("");
        hm.getCbKategori().setSelectedItem(null);
        hm.getCbJenis().setSelectedItem(null);
    }
    
    //menghapus data yang dipilih
    public void Hapus() {
        if(!hm.getTxtKode().getText().trim().isEmpty()) {
            
        } else {
            String kode = (hm.getTxtKode().getText());
            impToko.Hapus(kode);
            JOptionPane.showMessageDialog(hm, "Data Berhasil dihapus!");
        }
    }

    //menyimpan data
    public void SimpanData() {
        m_Toko toko = new m_Toko();
        toko.setkode(hm.getTxtKode().getText());
        toko.setnama(hm.getTxtNama().getText());
        toko.setharga(hm.getTxtHarga().getText());
    
        toko.setkategori(hm.getCbKategori().getSelectedItem().toString());
        toko.setjenis(hm.getCbJenis().getSelectedItem().toString());
        impToko.SimpanData(toko);
    }
    
    //mengubah data
    public void Ubah() {
        m_Toko toko = new m_Toko();
        toko.setkode(hm.getTxtKode().getText());
        toko.setnama(hm.getTxtKode().getText());
        toko.setkategori(hm.getCbKategori().getSelectedItem().toString());
        toko.setjenis(hm.getCbJenis().getSelectedItem().toString());
        toko.setharga(hm.getTxtHarga().getText());
        impToko.Ubah(toko);
    }
    
    public void isiTable() {
        lt = impToko.getAll();
        tableModelToko tmt = new tableModelToko(lt);
        hm.getTableData().setModel(tmt);
    }
    
    public void isiField(int row) {
        hm.getTxtKode().setText(lt.get(row).getkode().toString());
        hm.getTxtNama().setText(lt.get(row).getnama().toString());
        hm.getCbKategori().setSelectedItem(lt.get(row).getkategori().toString());
        hm.getCbJenis().setSelectedItem(lt.get(row).getjenis().toString());
        hm.getTxtHarga().setText(lt.get(row).getharga().toString());
    }
    
    public void CariKategori() {
        if(hm.getCbCariKategori().getSelectedItem().toString().isEmpty) {
            impToko.getCariKategori((String)hm.getCbCariKategori().getSelectedItem());
            isiTableCariKategori();
        } else {
            JOPtionPane.showMessageDialog(hm, "Silahka Pilih Kategori!");
        }
    }
    
    public void isiTableCariKategori() {
        lt = impToko.getCariKategori((String)hm.getCbKategori().getSelectedItem());
        tableModelToko tmt = new tableModelToko(lt);
        hm.getTableData().setModel(tmt);
    }
}