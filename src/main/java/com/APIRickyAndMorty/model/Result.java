package com.APIRickyAndMorty.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Result {

    private String id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private URL origin;
    private URL location;
    private String image;
    private String[] episode;
    private String url;
    private String created;

    @Override
    public String toString() {
        return "Result{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", origin=" + origin +
                ", location=" + location +
                ", image='" + image + '\'' +
                ", episode=" + printEpisode(episode) +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }

    /**
     * Código tomado del repositorio de barreracarlosandres
     * URL: https://github.com/barreracarlosandres
     */
    private String printEpisode(String[] episodes){
        StringBuilder salida = new StringBuilder();
        for(String s: episodes){
            if( s.equals(episodes[episodes.length-1]) ) {
                salida.append(s);
            } else {
                salida.append(s).append("\n\t\t\t");
            }
        }
        return salida.toString();
    }
}
