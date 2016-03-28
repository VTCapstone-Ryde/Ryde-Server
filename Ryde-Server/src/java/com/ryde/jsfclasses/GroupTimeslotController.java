package com.ryde.jsfclasses;

import com.ryde.entity.GroupTimeslot;
import com.ryde.jsfclasses.util.JsfUtil;
import com.ryde.jsfclasses.util.JsfUtil.PersistAction;
import com.ryde.sessionbean.GroupTimeslotFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("groupTimeslotController")
@SessionScoped
public class GroupTimeslotController implements Serializable {

    @EJB
    private com.ryde.sessionbean.GroupTimeslotFacade ejbFacade;
    private List<GroupTimeslot> items = null;
    private GroupTimeslot selected;

    public GroupTimeslotController() {
    }

    public GroupTimeslot getSelected() {
        return selected;
    }

    public void setSelected(GroupTimeslot selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private GroupTimeslotFacade getFacade() {
        return ejbFacade;
    }

    public GroupTimeslot prepareCreate() {
        selected = new GroupTimeslot();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("GroupTimeslotCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("GroupTimeslotUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("GroupTimeslotDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<GroupTimeslot> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public GroupTimeslot getGroupTimeslot(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<GroupTimeslot> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<GroupTimeslot> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = GroupTimeslot.class)
    public static class GroupTimeslotControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GroupTimeslotController controller = (GroupTimeslotController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "groupTimeslotController");
            return controller.getGroupTimeslot(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof GroupTimeslot) {
                GroupTimeslot o = (GroupTimeslot) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), GroupTimeslot.class.getName()});
                return null;
            }
        }

    }

}
