package pt.ulusofona.deisi.aedProj2018;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static ArrayList <Filme> parseMovieFiles() {
        String nomeFicheiroFilme = "deisi_movies.txt";
        ArrayList<Filme> filmeArrayList = new ArrayList<Filme>();
        try {
            File ficheiroFilme = new File(nomeFicheiroFilme);
            Scanner leitorFicheiroFilme = new Scanner(ficheiroFilme);


            while (leitorFicheiroFilme.hasNextLine()) {
                String linha = leitorFicheiroFilme.nextLine();

                String dados[] = linha.split(":");
                int id = Integer.parseInt(dados[0]);
                String title = dados[1];
                String data = dados[2];
                int budget = Integer.parseInt(dados[3]); //encontrar metodo para se tornar como unsigned int
                double duration = Double.parseDouble(dados[4]);
                double votesMedia = Double.parseDouble(dados[5]);
                int votesNumber = Integer.parseInt(dados[6]); //encontrar metodo para se tornar como unsigned int

                if (dados.length > 7 || id < 0) {
                    continue;
                }

                System.out.println("ID: " + id);
                System.out.println("Nome do Filme: " + title);
                System.out.println("Data de Estreia: " + data);
                System.out.println("Orçamento do Filme: " + budget);
                System.out.println("Duração do Filme: " + votesMedia);
                System.out.println("Numero de Votos: " + votesNumber);

                Filme filme = new Filme(id, title, data, budget, duration, votesMedia, votesNumber);
                filmeArrayList.add(filme);
            }

            leitorFicheiroFilme.close();

        } catch (FileNotFoundException exception) {
            String mensagem = "Erro: o ficheiro " + nomeFicheiroFilme + "não foi encontrado.";
            System.out.println(mensagem);

        }
        return filmeArrayList;

    } //descobrir o erro detetado no drop project

    public static ArrayList <Actor> parseActorFiles() {
        ArrayList<Actor> actorArrayList = new ArrayList<Actor>();
        String nomeFicheiroActor = "deisi_actors.txt";

        try {
            File ficheiroActor = new File(nomeFicheiroActor);
            Scanner leitorFicheiroActor = new Scanner(ficheiroActor);
            while (leitorFicheiroActor.hasNextLine()) {
                String linha = leitorFicheiroActor.nextLine();

                String dados[] = linha.split(":");
                int id = Integer.parseInt(dados[0]);
                String actorName = dados[1];
                Boolean masculine = Boolean.valueOf(dados[2]);
                int idFilme = Integer.parseInt(dados[3]);

                if (dados.length > 4 || id < 0 || idFilme < 0) {
                    continue;
                }
                Actor actor = new Actor(id, actorName, masculine, idFilme);
                actorArrayList.add(actor);

            }
            leitorFicheiroActor.close();

        } catch (FileNotFoundException exception) {
            String mensagem = "Erro: o ficheiro " + nomeFicheiroActor + "não foi encontrado.";
            System.out.println(mensagem);
        }
        return actorArrayList;
    }

    public static ArrayList<Genero> parseGenreFiles(){
         String nomeFicheiroGenero = "deisi_genres.txt";
         ArrayList<Genero> genreArrayList = new ArrayList<Genero>();
         try{
            File ficheiroGenero = new File(nomeFicheiroGenero);
            Scanner leitorFicheiroGenero = new Scanner(ficheiroGenero);

            while (leitorFicheiroGenero.hasNextLine()) {
                String linha = leitorFicheiroGenero.nextLine();

                String dados[] = linha.split(":");
                String genero = dados[0];
                int idFilme = Integer.parseInt(dados[1]);

                if (dados.length > 2 || idFilme < 0) {
                    continue;
                }
                Genero genre = new Genero(genero, idFilme);
                genreArrayList.add(genre);
            }
            leitorFicheiroGenero.close();
        }
        catch (FileNotFoundException exception) {
            String mensagem = "Erro: o ficheiro " + nomeFicheiroGenero + "não foi encontrado.";
            System.out.println(mensagem);
        }
        return genreArrayList;
     }

}
