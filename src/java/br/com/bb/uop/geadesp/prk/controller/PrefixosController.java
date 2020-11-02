package br.com.bb.uop.geadesp.prk.controller;

import br.com.bb.uop.geadesp.prk.entities.Prefixos;
import br.com.bb.uop.geadesp.prk.entities.Jurisdicionadas;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import java.util.Collection;
import br.com.bb.uop.geadesp.prk.facade.PrefixosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "prefixosController")
@ViewScoped
public class PrefixosController extends AbstractController<Prefixos> {

    // Flags to indicate if child collections are empty
    private boolean isJurisdicionadasCollectionEmpty;
    private boolean isTagsCollectionEmpty;

    public PrefixosController() {
        // Inform the Abstract parent controller of the concrete Prefixos Entity
        super(Prefixos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsJurisdicionadasCollectionEmpty();
        this.setIsTagsCollectionEmpty();
    }

    public boolean getIsJurisdicionadasCollectionEmpty() {
        return this.isJurisdicionadasCollectionEmpty;
    }

    private void setIsJurisdicionadasCollectionEmpty() {
        Prefixos selected = this.getSelected();
        if (selected != null) {
            PrefixosFacade ejbFacade = (PrefixosFacade) this.getFacade();
            this.isJurisdicionadasCollectionEmpty = ejbFacade.isJurisdicionadasCollectionEmpty(selected);
        } else {
            this.isJurisdicionadasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Jurisdicionadas entities
     * that are retrieved from Prefixos and returns the navigation outcome.
     *
     * @return navigation outcome for Jurisdicionadas page
     */
    public String navigateJurisdicionadasCollection() {
        Prefixos selected = this.getSelected();
        if (selected != null) {
            PrefixosFacade ejbFacade = (PrefixosFacade) this.getFacade();
            Collection<Jurisdicionadas> selectedJurisdicionadasCollection = ejbFacade.findJurisdicionadasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Jurisdicionadas_items", selectedJurisdicionadasCollection);
        }
        return "/app/jurisdicionadas/index";
    }

    public boolean getIsTagsCollectionEmpty() {
        return this.isTagsCollectionEmpty;
    }

    private void setIsTagsCollectionEmpty() {
        Prefixos selected = this.getSelected();
        if (selected != null) {
            PrefixosFacade ejbFacade = (PrefixosFacade) this.getFacade();
            this.isTagsCollectionEmpty = ejbFacade.isTagsCollectionEmpty(selected);
        } else {
            this.isTagsCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tags entities that are
     * retrieved from Prefixos and returns the navigation outcome.
     *
     * @return navigation outcome for Tags page
     */
    public String navigateTagsCollection() {
        Prefixos selected = this.getSelected();
        if (selected != null) {
            PrefixosFacade ejbFacade = (PrefixosFacade) this.getFacade();
            Collection<Tags> selectedTagsCollection = ejbFacade.findTagsCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tags_items", selectedTagsCollection);
        }
        return "/app/tags/index";
    }

}
