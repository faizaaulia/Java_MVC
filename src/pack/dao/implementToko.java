/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;

import java.util.List;
import pack.model.m_Toko;

/**
 *
 * @author faizaaulia
 */
public interface implementToko {
    public void TampilData(m_Toko a); 
    public void UbahData(m_Toko a); 
    public void SimpanData(m_Toko a); 
    public void HapusData(String kode); 
    public List<m_Toko> getCariKategori(String kategori);
}
