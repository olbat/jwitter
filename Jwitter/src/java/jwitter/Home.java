/*
 * Home.java
 *
 * Created on 15 mai 2009, 16:26:30
 */
 
package jwitter;

import com.sun.data.provider.impl.CachedRowSetDataProvider;
import com.sun.data.provider.impl.ListDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import javax.faces.FacesException;
import javax.faces.convert.IntegerConverter;

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
        usersDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.usersRowSet}"));
        usersDataProvider1.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.usersRowSet}"));
        usersDataProvider2.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.usersRowSet1}"));
        usersDataProvider3.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.usersRowSet1}"));
    }
    private CachedRowSetDataProvider usersDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getUsersDataProvider() {
        return usersDataProvider;
    }

    public void setUsersDataProvider(CachedRowSetDataProvider crsdp) {
        this.usersDataProvider = crsdp;
    }
    private ListDataProvider listDataProvider1 = new ListDataProvider();

    public ListDataProvider getListDataProvider1() {
        return listDataProvider1;
    }

    public void setListDataProvider1(ListDataProvider ldp) {
        this.listDataProvider1 = ldp;
    }
    private CachedRowSetDataProvider usersDataProvider1 = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getUsersDataProvider1() {
        return usersDataProvider1;
    }

    public void setUsersDataProvider1(CachedRowSetDataProvider crsdp) {
        this.usersDataProvider1 = crsdp;
    }
    private CachedRowSetDataProvider usersDataProvider2 = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getUsersDataProvider2() {
        return usersDataProvider2;
    }

    public void setUsersDataProvider2(CachedRowSetDataProvider crsdp) {
        this.usersDataProvider2 = crsdp;
    }
    private CachedRowSetDataProvider usersDataProvider3 = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getUsersDataProvider3() {
        return usersDataProvider3;
    }

    public void setUsersDataProvider3(CachedRowSetDataProvider crsdp) {
        this.usersDataProvider3 = crsdp;
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
        usersDataProvider.close();
        usersDataProvider1.close();
        usersDataProvider2.close();
        usersDataProvider3.close();
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }
    
}

