package com.example.smallbirdking.seriess.function;

import java.util.List;

/**
 * Created by smallbirdking on 2015/10/13.
 */
public class response {


    /**
     * page : 1
     * results : [{"backdrop_path":"/dpNeXLEnuKzAvbNwveJhNEiQvXZ.jpg","first_air_date":"2015-04-10","genre_ids":[28,80],"id":61889,"original_language":"en","original_name":"Marvel's Daredevil","overview":"Lawyer-by-day Matt Murdock uses his heightened senses from being blinded as a young boy to fight crime at night on the streets of Hell\u2019s Kitchen as Daredevil.","origin_country":["US"],"poster_path":"/itrCovJkuH7I8SJ98jxrInnwm2y.jpg","popularity":7.303558,"name":"Marvel's Daredevil","vote_average":8,"vote_count":69},{"backdrop_path":"/rohZmzCy7oQJ5U4TRSxHegVKw30.jpg","first_air_date":"2010-02-13","genre_ids":[10759,16,35],"id":17572,"original_language":"en","original_name":"Kick Buttowski: Suburban Daredevil","overview":"Kick Buttowski: Suburban Daredevil is an Emmy Nominated animated television series created by animator Sandro Corsaro, about a young boy named Clarence \"Kick\" Buttowski, who aspires to become the world's greatest daredevil. It became the fourth Disney XD original series and the first animated series. The show premiered on February 13, 2010, with two episodes airing the first day. Also the series premiered on Disney Channel Asia on May 28, 2010 There are two 11-minute segments per show. The show uses Toon Boom Animation software. There are also some 3D-animated elements. The series is executive-produced and directed by Chris Savino. and Sandro Corsaro. Many of the characters and situations were based on the Corsaro's childhood growing up in Stoneham, Massachusetts.","origin_country":[],"poster_path":"/29nNP9wNeiD0q6a90XH78zniokc.jpg","popularity":0.739172,"name":"Kick Buttowski: Suburban Daredevil","vote_average":0,"vote_count":0},{"backdrop_path":null,"first_air_date":"2003-11-07","genre_ids":[16],"id":45370,"original_language":"en","original_name":"Daredevil Guardian Devil","overview":null,"origin_country":[],"poster_path":null,"popularity":1.002571,"name":"Daredevil Guardian Devil","vote_average":0,"vote_count":0},{"backdrop_path":null,"first_air_date":null,"genre_ids":[16],"id":14062,"original_language":"en","original_name":"Super Dave: Daredevil for Hire","overview":"Super Dave: Daredevil for Hire is a DiC animated television series.\n\nIn the United States, the show premiered on September 9, 1992 on FOX. The series was cancelled after its first season, but a special based on the series titled \"The Super Dave Superbowl of Knowledge\" aired on January 29, 1994.\n\nThe show starred and was based on the comedy of Bob Einstein and his Super Dave Osborne persona. Both Bob Einstein and Art Irizawa provided the voices for Super Dave and his assistant, Fuji Hakahito, and also appeared as their characters in live-action skits which ended each episode.\n\nHalfway through the show's initial run, Irizawa was asked to modify his voice for Fuji, following complaints to Fox from Asian-American groups that the character was an offensive stereotype. Irizawa subsequently re-recorded his dialogue for all of the show's episodes.\n\nAt present, DIC has no plans to release the show on home video.","origin_country":["US"],"poster_path":"/pvARdZ0wbUtCz3jG1HfDjqv4xT9.jpg","popularity":1.027,"name":"Super Dave: Daredevil for Hire","vote_average":0,"vote_count":0},{"backdrop_path":"/3SPufNVaUg53fDod87iNjPnkkIb.jpg","first_air_date":"2009-09-14","genre_ids":[99],"id":35124,"original_language":"en","original_name":"Daredevils","overview":null,"origin_country":["GB"],"poster_path":null,"popularity":1.005946,"name":"Daredevils","vote_average":0,"vote_count":0},{"backdrop_path":null,"first_air_date":"2006-05-03","genre_ids":[],"id":23624,"original_language":"en","original_name":"Celebrity Daredevils","overview":"","origin_country":["GB"],"poster_path":null,"popularity":0.002606,"name":"Celebrity Daredevils","vote_average":0,"vote_count":0}]
     * total_pages : 1
     * total_results : 6
     */

    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsEntity> results;

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        /**
         * backdrop_path : /dpNeXLEnuKzAvbNwveJhNEiQvXZ.jpg
         * first_air_date : 2015-04-10
         * genre_ids : [28,80]
         * id : 61889
         * original_language : en
         * original_name : Marvel's Daredevil
         * overview : Lawyer-by-day Matt Murdock uses his heightened senses from being blinded as a young boy to fight crime at night on the streets of Hell’s Kitchen as Daredevil.
         * origin_country : ["US"]
         * poster_path : /itrCovJkuH7I8SJ98jxrInnwm2y.jpg
         * popularity : 7.303558
         * name : Marvel's Daredevil
         * vote_average : 8.0
         * vote_count : 69
         */

        private String backdrop_path;
        private String first_air_date;
        private int id;
        private String original_language;
        private String original_name;
        private String overview;
        private String poster_path;
        private double popularity;
        private String name;
        private double vote_average;
        private int vote_count;
        private List<Integer> genre_ids;
        private List<String> origin_country;

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public void setFirst_air_date(String first_air_date) {
            this.first_air_date = first_air_date;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public void setOriginal_name(String original_name) {
            this.original_name = original_name;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }

        public void setOrigin_country(List<String> origin_country) {
            this.origin_country = origin_country;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public String getFirst_air_date() {
            return first_air_date;
        }

        public int getId() {
            return id;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public String getOriginal_name() {
            return original_name;
        }

        public String getOverview() {
            return overview;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public double getPopularity() {
            return popularity;
        }

        public String getName() {
            return name;
        }

        public double getVote_average() {
            return vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public List<String> getOrigin_country() {
            return origin_country;
        }
    }
}
