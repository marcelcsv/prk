package br.com.bb.uop.geadesp.prk.controller;

import br.com.bb.uop.geadesp.prk.entities.Jurisdicionadas;
import br.com.bb.uop.geadesp.prk.facade.JurisdicionadasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "jurisdicionadasController")
@ViewScoped
public class JurisdicionadasController extends AbstractController<Jurisdicionadas> {

    @Inject
    private PrefixosController prefixoController;

    public JurisdicionadasController() {
        // Inform the Abstract parent controller of the concrete Jurisdicionadas Entity
        super(Jurisdicionadas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        prefixoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Prefixos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePrefixo(ActionEvent event) {
        Jurisdicionadas selected = this.getSelected();
        if (selected != null && prefixoController.getSelected() == null) {
            prefixoController.setSelected(selected.getPrefixo());
        }
    }

}
