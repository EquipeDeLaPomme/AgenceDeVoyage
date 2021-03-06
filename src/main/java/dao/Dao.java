package dao;

import java.util.List;

import model.Passager;
import model.Reservation;
import model.Vol;

/**
 * Contrat que tous les DAOs devront respecter.
 * 
 * @author ajc
 *
 * @param <T>
 * @param <PK>
 */
public interface Dao<T, PK>
{
    /**
     * Retourne la liste de tous les objets métiers de la source de données
     * 
     * @return Liste des objets métiers de la source de données
     */
    List<T> findAll();

    /**
     * Retourne un objet métier en fonction de sa clé primaire
     * 
     * @param id
     *            Clé primaire
     * @return L'objet métier trouvé
     */
    T findById(PK id);




}
