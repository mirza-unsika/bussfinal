package com.kel5.bus.demo_bus;

public class JadwalBus {
    private String tujuan;
    private String hari;
    private String jamKeberangkatan;
    private String namaBus;

    public JadwalBus(String tujuan, String hari, String jamKeberangkatan, String namaBus) {
        this.tujuan = tujuan;
        this.hari = hari;
        this.jamKeberangkatan = jamKeberangkatan;
        this.namaBus = namaBus;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getHari() {
        return hari;
    }

    public String getJamKeberangkatan() {
        return jamKeberangkatan;
    }

    public String getNamaBus() {
        return namaBus;
    }
}
