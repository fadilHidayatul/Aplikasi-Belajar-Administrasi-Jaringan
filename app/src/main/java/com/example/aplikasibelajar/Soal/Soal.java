package com.example.aplikasibelajar.Soal;

import java.util.List;

public class Soal {

    /**
     * pesan : soal ada
     * status : 200
     * data : [{"id_evaluasi":"3","id_materi":"14","soal":"hadahsfkja\r\n","pil_a":"hadahsfkja\r\n","pil_b":"hadahsfkja\r\n","pil_c":"hadahsfkja\r\n","pil_d":"hadahsfkja\r\n","pil_e":"hadahsfkja\r\n","kunci":"c"},{"id_evaluasi":"4","id_materi":"2","soal":"asd","pil_a":"qweq","pil_b":"asda","pil_c":"qwrrw","pil_d":"asd","pil_e":"zxc","kunci":"e"}]
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
         * id_evaluasi : 3
         * id_materi : 14
         * soal : hadahsfkja
         * pil_a : hadahsfkja
         * pil_b : hadahsfkja
         * pil_c : hadahsfkja
         * pil_d : hadahsfkja
         * pil_e : hadahsfkja
         * kunci : c
         * pembahasan : text
         */

        private String id_evaluasi;
        private String id_materi;
        private String soal;
        private String pil_a;
        private String pil_b;
        private String pil_c;
        private String pil_d;
        private String pil_e;
        private String kunci;
        private String pembahasan;

        public String getId_evaluasi() {
            return id_evaluasi;
        }

        public void setId_evaluasi(String id_evaluasi) {
            this.id_evaluasi = id_evaluasi;
        }

        public String getId_materi() {
            return id_materi;
        }

        public void setId_materi(String id_materi) {
            this.id_materi = id_materi;
        }

        public String getSoal() {
            return soal;
        }

        public void setSoal(String soal) {
            this.soal = soal;
        }

        public String getPil_a() {
            return pil_a;
        }

        public void setPil_a(String pil_a) {
            this.pil_a = pil_a;
        }

        public String getPil_b() {
            return pil_b;
        }

        public void setPil_b(String pil_b) {
            this.pil_b = pil_b;
        }

        public String getPil_c() {
            return pil_c;
        }

        public void setPil_c(String pil_c) {
            this.pil_c = pil_c;
        }

        public String getPil_d() {
            return pil_d;
        }

        public void setPil_d(String pil_d) {
            this.pil_d = pil_d;
        }

        public String getPil_e() {
            return pil_e;
        }

        public void setPil_e(String pil_e) {
            this.pil_e = pil_e;
        }

        public String getKunci() {
            return kunci;
        }

        public void setKunci(String kunci) {
            this.kunci = kunci;
        }

        public String getPembahasan(){
            return pembahasan;
        }

        public void setPembahasan(String pembahasan){
            this.pembahasan = pembahasan;
        }
    }
}
