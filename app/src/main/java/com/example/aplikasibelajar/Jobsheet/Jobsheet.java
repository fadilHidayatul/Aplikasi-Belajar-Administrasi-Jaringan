package com.example.aplikasibelajar.Jobsheet;

import java.util.List;

public class Jobsheet {

    /**
     * pesan : jobsheet ada
     * status : 200
     * data : [{"id_jobsheet":"7","judul_jobsheet":"JOB PROXY SERVER","deskripsi":"","file":"bf66cbba2dba1c43a21734280d32ae75.pdf"},{"id_jobsheet":"6","judul_jobsheet":"JOB INTERNET GATEWAY","deskripsi":"","file":"a388d355922fa434bfa4a74b3140670c.pdf"},{"id_jobsheet":"5","judul_jobsheet":"JOB FIREWALL","deskripsi":"","file":"680c1d624911dbb171d6d01ac5dbeea8.pdf"}]
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
         * id_jobsheet : 7
         * judul_jobsheet : JOB PROXY SERVER
         * deskripsi :
         * file : bf66cbba2dba1c43a21734280d32ae75.pdf
         */

        private String id_jobsheet;
        private String judul_jobsheet;
        private String deskripsi;
        private String file;

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
