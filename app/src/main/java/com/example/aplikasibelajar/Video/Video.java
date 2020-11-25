package com.example.aplikasibelajar.Video;

import java.util.List;

public class Video {

    /**
     * pesan : video ada
     * status : 200
     * data : [{"id_video":"1","judul_video":"upin ipin 2","link":"https://www.youtube.com/results?search_query=upin+ipin"},{"id_video":"2","judul_video":"video 2","link":null}]
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
         * id_video : 1
         * judul_video : upin ipin 2
         * link : https://www.youtube.com/results?search_query=upin+ipin
         */

        private String id_video;
        private String judul_video;
        private String link;

        public String getId_video() {
            return id_video;
        }

        public void setId_video(String id_video) {
            this.id_video = id_video;
        }

        public String getJudul_video() {
            return judul_video;
        }

        public void setJudul_video(String judul_video) {
            this.judul_video = judul_video;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
