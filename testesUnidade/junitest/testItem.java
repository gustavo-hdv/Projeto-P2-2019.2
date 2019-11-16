package junitest;

import org.junit.jupiter.api.Test;

import projeto.Item;

import static org.junit.jupiter.api.Assertions.*;

class testItem {

    @Test
    void constructItemBasico(){
        try {
            Item item = new Item("Dados colocados na planilha.");
        }catch (Exception e){
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void constructItemNulo(){
        try {
            Item item = new Item(null);
            fail("Era esperado excecao");
        }catch (NullPointerException e){

        }
    }

    @Test
    void constructItemVazio(){
        try {
            Item item = new Item("  ");
            fail("Era esperado excecao");
        }catch (IllegalArgumentException e){

        }
    }

    @Test
    void exibeEstadoBasico() {
        try {
            Item item = new Item("Dados colocados na planilha.");
            assertEquals("PENDENTE", item.exibeEstado());
        }catch (Exception e){
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void exibeEstadoAlterado() {
        try {
            Item item = new Item("Dados colocados na planilha.");
            item.alteraEstado();
            assertEquals("REALIZADO", item.exibeEstado());
        }catch (Exception e){
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void alteraEstado() {
        try {
            Item item = new Item("Dados colocados na planilha.");
            assertEquals("PENDENTE", item.exibeEstado());
            item.alteraEstado();
            assertEquals("REALIZADO", item.exibeEstado());
        }catch (Exception e){
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void exibeItem() {
        try {
            Item item = new Item("Dados colocados na planilha.");
            assertEquals("PENDENTE - Dados colocados na planilha.", item.exibeItem());
        }catch (Exception e){
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void exibeItemAlterado() {
        try {
            Item item = new Item("Dados colocados na planilha.");
            assertEquals("PENDENTE - Dados colocados na planilha.", item.exibeItem());
            item.alteraEstado();
            assertEquals("REALIZADO - Dados colocados na planilha.", item.exibeItem());
        }catch (Exception e){
            fail("Nao era esperado excecao");
        }
    }
}