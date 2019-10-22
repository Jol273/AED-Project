package pt.ulusofona.deisi.aedProj2018;

public class Filme {

        int idFilme;
        String title;
        String data;
        int budget;
        double duration;
        double votesMedia;
        int votesNumber;
        Actor actors;
        Genero genres;

        public String toString(){
            return idFilme + " | " + title + " | " + data;
        }

        Filme(int idFilme,String title,String data,int budget,double duration,double votesMedia,int votesNumber){
            this.idFilme = idFilme;
            this.title = title;
            this.data = data;
            this.budget = budget;
            this.duration = duration;
            this.votesMedia = votesMedia;
            this.votesNumber = votesNumber;
        }
        Filme(int idFilme,String title,Actor actors,Genero genres,String data){
            this.idFilme = idFilme;
            this.title = title;
            this.actors = actors;
            this.genres = genres;
            this.data = data;
        }
}
