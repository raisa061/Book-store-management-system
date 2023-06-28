/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinebookstore;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "book_details", catalog = "busm", schema = "")
@NamedQueries({
    @NamedQuery(name = "BookDetails.findAll", query = "SELECT b FROM BookDetails b")
    , @NamedQuery(name = "BookDetails.findById", query = "SELECT b FROM BookDetails b WHERE b.id = :id")
    , @NamedQuery(name = "BookDetails.findByBookname", query = "SELECT b FROM BookDetails b WHERE b.bookname = :bookname")
    , @NamedQuery(name = "BookDetails.findByPublisher", query = "SELECT b FROM BookDetails b WHERE b.publisher = :publisher")
    , @NamedQuery(name = "BookDetails.findByPrice", query = "SELECT b FROM BookDetails b WHERE b.price = :price")})
public class BookDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "bookname")
    private int bookname;
    @Basic(optional = false)
    @Column(name = "publisher")
    private int publisher;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;

    public BookDetails() {
    }

    public BookDetails(Integer id) {
        this.id = id;
    }

    public BookDetails(Integer id, int bookname, int publisher, int price) {
        this.id = id;
        this.bookname = bookname;
        this.publisher = publisher;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getBookname() {
        return bookname;
    }

    public void setBookname(int bookname) {
        int oldBookname = this.bookname;
        this.bookname = bookname;
        changeSupport.firePropertyChange("bookname", oldBookname, bookname);
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        int oldPublisher = this.publisher;
        this.publisher = publisher;
        changeSupport.firePropertyChange("publisher", oldPublisher, publisher);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        int oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookDetails)) {
            return false;
        }
        BookDetails other = (BookDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "onlinebookstore.BookDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
