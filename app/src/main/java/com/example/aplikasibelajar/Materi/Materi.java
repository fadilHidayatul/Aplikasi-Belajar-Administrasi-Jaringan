package com.example.aplikasibelajar.Materi;

import java.util.List;

public class Materi {

    /**
     * pesan : data ada
     * status : 200
     * data : [{"id_materi":"14","judul_materi":"WER","deskripsi":"SDF","file":"aa585eac3f53a5aaa2f267b48119a2ab.pdf"},{"id_materi":"15","judul_materi":"Sistem Operasi Jaringan","deskripsi":null,"file":null}]
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
         * id_materi : 14
         * judul_materi : WER
         * deskripsi : SDF
         * file : aa585eac3f53a5aaa2f267b48119a2ab.pdf
         */

        private String id_materi;
        private String judul_materi;
        private String deskripsi;
        private String file;

        public String getId_materi() {
            return id_materi;
        }

        public void setId_materi(String id_materi) {
            this.id_materi = id_materi;
        }

        public String getJudul_materi() {
            return judul_materi;
        }

        public void setJudul_materi(String judul_materi) {
            this.judul_materi = judul_materi;
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
