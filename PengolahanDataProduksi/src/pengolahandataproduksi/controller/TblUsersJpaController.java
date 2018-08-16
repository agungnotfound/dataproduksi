/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengolahandataproduksi.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pengolahandataproduksi.controller.exceptions.NonexistentEntityException;
import pengolahandataproduksi.controller.exceptions.PreexistingEntityException;
import pengolahandataproduksi.model.TblUsers;

/**
 *
 * @author agungnotfound
 */
public class TblUsersJpaController implements Serializable {

    public TblUsersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TblUsers tblUsers) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tblUsers);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTblUsers(tblUsers.getUsername()) != null) {
                throw new PreexistingEntityException("TblUsers " + tblUsers + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TblUsers tblUsers) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tblUsers = em.merge(tblUsers);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tblUsers.getUsername();
                if (findTblUsers(id) == null) {
                    throw new NonexistentEntityException("The tblUsers with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TblUsers tblUsers;
            try {
                tblUsers = em.getReference(TblUsers.class, id);
                tblUsers.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tblUsers with id " + id + " no longer exists.", enfe);
            }
            em.remove(tblUsers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TblUsers> findTblUsersEntities() {
        return findTblUsersEntities(true, -1, -1);
    }

    public List<TblUsers> findTblUsersEntities(int maxResults, int firstResult) {
        return findTblUsersEntities(false, maxResults, firstResult);
    }

    private List<TblUsers> findTblUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TblUsers.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TblUsers findTblUsers(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TblUsers.class, id);
        } finally {
            em.close();
        }
    }

    public int getTblUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TblUsers> rt = cq.from(TblUsers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
