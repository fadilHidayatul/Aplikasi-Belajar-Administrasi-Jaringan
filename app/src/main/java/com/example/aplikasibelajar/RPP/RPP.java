package com.example.aplikasibelajar.RPP;

import java.util.List;

public class RPP {

    /**
     * pesan : rpp ada
     * status : 200
     * data : [{"id_rpp":"9","judul_rpp":"RPP FIREWALL","deskripsi":"","file":"d6112a65dad6c811ca89a1cf490c8eb1.pdf"},{"id_rpp":"10","judul_rpp":"RPP INTERNET GATEWAY","deskripsi":"","file":"83ded60d18447c5b43a66a66ebc98477.pdf"},{"id_rpp":"11","judul_rpp":"RPP PROXY SERVER","deskripsi":"","file":"1a4028fc6cf214ca4db94d06388789f0.pdf"}]
     */

    private String pesan;
    private int status;
    private List<DataBean> data;

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id_rpp : 9
         * judul_rpp : RPP FIREWALL
         * deskripsi :
         * file : d6112a65dad6c811ca89a1cf490c8eb1.pdf
         */

        private String id_rpp;
        private String judul_rpp;
        private String deskripsi;
        private String file;

        public String getId_rpp() {
            return id_rpp;
        }

        public void setId_rpp(String id_rpp) {
            this.id_rpp = id_rpp;
        }

        public String getJudul_rpp() {
            return judul_rpp;
        }

        public void setJudul_rpp(String judul_rpp) {
            this.judul_rpp = judul_rpp;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }
}
