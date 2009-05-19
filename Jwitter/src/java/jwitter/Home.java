/*
 * Home.java
 *
 * Created on 15 mai 2009, 16:26:30
 */
 
package jwitter;


import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import javax.faces.FacesException;
import com.sun.webui.jsf.model.Option;
import java.util.Collection;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author cygan0031
 */
public class Home extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        int size = 2;
        Collection following = null;
        Option[] options = null;

        if(this.getSessionMap().get("user") != null) {
            following = ((User)this.getSessionMap().get("user")).getFollowing();
        }

        if(following != null && following.size() > 0) {
            size += following.size();
        }

        options = new Option[size];
        options[0] = new Option("public", "public");
        options[1] = new Option("private", "private");
        int i = 2;

        if(following != null) {
            for(Object o : following) {
                options[i++] = new Option(((User)o).getId(), "@" + ((User)o).getUsername());
            }
        }
        
        dropDown1DefaultOptions.setOptions(options);
    }
    private SingleSelectOptionsList dropDown1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDropDown1DefaultOptions() {
        return dropDown1DefaultOptions;
    }

    public void setDropDown1DefaultOptions(SingleSelectOptionsList ssol) {
        this.dropDown1DefaultOptions = ssol;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Home() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        if(this.getSessionMap().get("user") == null) {
            this.getRequestMap().put("messages", Message.getAllPublic());
        } else {
            if(((User)this.getSessionMap().get("user")).isAdmin()) {
                this.getRequestMap().put("messages", Message.getAll());
            } else {
                this.getRequestMap().put("messages", Message.getAllForUser((User)this.getSessionMap().get("user")));
            }
        }
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MessageBean getMessageBean() {
        return (MessageBean) getBean("MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String link_delete_action() {
        Message m = new Message(Integer.parseInt(this.getFacesContext().getExternalContext().getRequestParameterMap().get("id")));

        if(m.delete())
            this.getSessionMap().put("message_valid", "Message deleted!");

        return null;
    }

    public String button_update_action() {
        Message m = new Message();
        m.setUser_id(Integer.parseInt(((User)this.getSessionMap().get("user")).getId()));
        m.setContent(this.getMessageBean().getContent());
        String selected = (String)this.getMessageBean().getScope();

        if(selected == null) {
            this.getSessionMap().put("message_error", "You need to select the scope");
        } else if(selected.compareTo("public") == 0) {
            m.setPrivacy(Message.PRIVACY_PUBLIC);
        } else if(selected.compareTo("private") == 0) {
            m.setPrivacy(Message.PRIVACY_PRIVATE);
        } else {
            m.setPrivacy(Message.PRIVACY_DIRECT);
            m.setFriend_id(Integer.parseInt(selected));
        }

        if(m.save())
            this.getSessionMap().put("message_valid", "You jwitted successfully!");

        return null;
    }
    
}

