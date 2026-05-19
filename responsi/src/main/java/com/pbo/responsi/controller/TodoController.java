/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.responsi.controller;
import com.pbo.responsi.dto.CartItemDTO;
import com.pbo.responsi.model.CartRepository;
import com.pbo.responsi.view.CartView;
/**
 *
 * @author Lab Informatika
 */
public class TodoController {
    private final CartRepository repository;
    private final CartView view;

    public TodoController() {
        this.repository = null;
        this.view = null;
    }
    public TodoController(CartRepository repository, CartView view){
        this.repository = repository;
        this.view = view;
        registerEvents();
        refreshTable();
    }
    
    private void registerEvents(){
        view.onAdd(e->handleAdd());
        view.onUpdate(e->handleUpdate());
        view.onDelete(e->handleDelete());
    }
    
    private void handleAdd(){
        String name = view.getNameInput();
        String priceStr = view.getPriceInput();
        if(name.isEmpty()){
            view.showMessage("Nama barang tidak boleh kosong");
            return;
        }
        
        boolean success = repository.insert(new CartItemDTO(name, priceStr));
        
        if(success){
            refreshTable();
            view.showMessage("Barang berhasil ditambahkan");
        } else {
            view.showMessage("Gagal menambahkan barang!");
        }
    }
    
    private void handleUpdate(){
        int selected = view.getSelectedRowItemName();
        if(selected == 1){
            view.showMessage("Pilih data terlebih dahulu");
            return;
        }
        String title = view.getTitleInput();
        String status = view.getStatusInput();
        if(title.isEmpty()){
            view.showMessage("Nama Barang tidak boleh kosong");
            return;
        }
        
        booelan success = repository.updateQuantity(title, selected);
        
        if(success){
            refreshTable();
            view.clearForm();
            view.showMessage("Barang berhasil diupdate");
        } else {
            view.showMessage("Gagal mengupdate barang!");
        }
    }
    
    private void handleDelete(){
        int seleced = view.getSelectedRowItemName();
        if(seleced == -1){
            view.showMessage("Pilih data terlebih dahulu");
            return;
        }
        
        int confirm = javax.swing.JOptionPane.showConfirmDialog(view, 
                "Apakah Anda yakin ingin menghapus barang ini?", "Konfirmasi Hapus",
                javax.swing.JOptionPane.YES_NO_OPTION);
        
        if(confirm == javax.swing.JOptionPane.YES_OPTION){
            booelan success repository.delete(seleced);
            if(success){
                refreshTable();
                view.clearForm();
                view.showMessage("Barang berhasil dihapus");
            } else {
                view.showMessage("Gagal menghapus barang!");
            }
        }
    }
    
    private void refreshTable(){
        view.showMessage(repository.getAll());
    }
}
