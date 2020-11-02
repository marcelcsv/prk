package br.com.bb.uop.geadesp.prk.controller;

import br.com.bb.uop.geadesp.prk.entities.Tags;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tagsController")
@ViewScoped
public class TagsController extends AbstractController<Tags> {

    @Inject
    private AtivaController ativaController;
    @Inject
    private PrefixosController prefixoController;
    @Inject
    private StatusController statusController;
    @Inject
    private UorPosController matriculaController;
    @Inject
    private UorPosController matriculaSolicitanteController;

    public TagsController() {
        // Inform the Abstract parent controller of the concrete Tags Entity
        super(Tags.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ativaController.setSelected(null);
        prefixoController.setSelected(null);
        statusController.setSelected(null);
        matriculaController.setSelected(null);
        matriculaSolicitanteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Ativa controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAtiva(ActionEvent event) {
        Tags selected = this.getSelected();
        if (selected != null && ativaController.getSelected() == null) {
            ativaController.setSelected(selected.getAtiva());
        }
    }

    /**
     * Sets the "selected" attribute of the Prefixos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePrefixo(ActionEvent event) {
        Tags selected = this.getSelected();
        if (selected != null && prefixoController.getSelected() == null) {
            prefixoController.setSelected(selected.getPrefixo());
        }
    }

    /**
     * Sets the "selected" attribute of the Status controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStatus(ActionEvent event) {
        Tags selected = this.getSelected();
        if (selected != null && statusController.getSelected() == null) {
            statusController.setSelected(selected.getStatus());
        }
    }

    /**
     * Sets the "selected" attribute of the UorPos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMatricula(ActionEvent event) {
        Tags selected = this.getSelected();
        if (selected != null && matriculaController.getSelected() == null) {
            matriculaController.setSelected(selected.getMatricula());
        }
    }

    /**
     * Sets the "selected" attribute of the UorPos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMatriculaSolicitante(ActionEvent event) {
        Tags selected = this.getSelected();
        if (selected != null && matriculaSolicitanteController.getSelected() == null) {
            matriculaSolicitanteController.setSelected(selected.getMatriculaSolicitante());
        }
    }

}
