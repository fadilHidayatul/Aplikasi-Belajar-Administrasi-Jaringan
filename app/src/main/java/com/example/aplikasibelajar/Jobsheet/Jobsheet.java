package com.example.aplikasibelajar.Jobsheet;

import java.util.List;

public class Jobsheet {

    /**
     * pesan : jobsheet ada
     * status : 200
     * data : [{"id_jobsheet":"1","judul_jobsheet":"jobsheet1","deskripsi":null,"file":null},{"id_jobsheet":"2","judul_jobsheet":"jobsheet2","deskripsi":null,"file":null}]
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
         * id_jobsheet : 1
         * judul_jobsheet : jobsheet1
         * deskripsi : null
         * file : null
         */

        private String id_jobsheet;
        private String judul_jobsheet;
        private Object deskripsi;
        private Object file;

        public String getId_jobsheet() {
            return id_jobsheet;
        }

        public void setId_jobsheet(String id_jobsheet) {
            this.id_jobsheet = id_jobsheet;
        }

        public String getJudul_jobsheet() {
            return judul_jobsheet;
        }

        public void setJudul_jobsheet(String judul_jobsheet) {
            this.judul_jobsheet = judul_jobsheet;
        }

        public Object getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(Object deskripsi) {
            this.deskripsi = deskripsi;
        }

        public Object getFile() {
            return file;
        }

        public void setFile(Object file) {
            this.file = file;
        }
    }
}
