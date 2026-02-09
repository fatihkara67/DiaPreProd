package com.efectura.utilities;

import com.efectura.pages.*;
import com.efectura.pages.BPM.*;
import com.efectura.pages.MDMPages.AccountManagement.AccountHomePage;
import com.efectura.pages.MDMPages.AssetManagement.Asset;
import com.efectura.pages.MDMPages.AssetManagement.AssetEditPage;
import com.efectura.pages.MDMPages.CampaignManagement.CampaignHomePage;
import com.efectura.pages.MDMPages.ConnectorManagement4.ConnectorHomePage;
import com.efectura.pages.MDMPages.ContactManagement.ContactEditPage;
import com.efectura.pages.MDMPages.ContactManagement.ContactHomePage;
import com.efectura.pages.MDMPages.ContactManagement.ContactHomePageMyContactPage;
import com.efectura.pages.MDMPages.ContractManagement.Contract;
import com.efectura.pages.MDMPages.EditItemPage;
import com.efectura.pages.MDMPages.GiftManagement.Gift;
import com.efectura.pages.MDMPages.GiftManagement.GiftHomePage;
import com.efectura.pages.MDMPages.ItemOverviewPage;
import com.efectura.pages.SettingsPages.Families;
import com.efectura.pages.SettingsPages.TagsPage;
import com.efectura.pages.SystemPages.BlackListPage;
import com.efectura.pages.SystemPages.CurrenciesPage;
import com.efectura.pages.SystemPages.TableEditorPage;
//import com.efectura.pages.SystemPage.UserManagement.Users;
//import com.efectura.pages.SystemPage.UserManagement.UsersLogs;


public class Pages {

    private HomePage homePage;
    private LoginPage loginPage;
    private Contract contract;
    private Asset asset;
    private Gift gift;
    private GiftHomePage giftHomePage;
    private ContactHomePage contactHomePage;
    private ContactHomePageMyContactPage contactHomePageMyContactPage;
    private ContactEditPage contactEditPage;
    private AssetEditPage assetEditPage;
    private BlackListPage  blackListPage;
//    private EventHomePage  eventHomePage;
    private CampaignHomePage campaignHomePage;
//    private KPIHomePage kpiHomePage;
    private Families families;
//    private Attributes attributes;
//    private Users users;
    private ConnectorHomePage connectorHomePage;
//    private UserHomePage userHomePage;
//    private UsersLogs usersLogs;
    private AccountHomePage accountHomePage;
//    private ProductHomePage productHomePage;
    private CurrenciesPage currenciesPage;
    private TagsPage tagsPage;
//    private Import importPage;
    private ModulFlows modulFlows;
    private TaskList taskList;
    private Offstand offstand;
    private EditItemPage editItemPage;
    private GeneralPage generalPage;
    private MenuFlows menuFlows;
    private Panel panel;
    private ItemOverviewPage itemOverviewPage;
    private DbProcess dbProcess;
    private TableEditorPage tableEditorPage;
    private ReportPage reportPage;
    private Message message;
    private Membership_AccountRulePage membershipAccountRulePage;

    public Pages() {
            this.homePage =new HomePage();
            this.loginPage =new LoginPage();
            this.contract=new Contract();
            this.asset= new Asset();
            this.gift=new Gift();
            this.contactHomePage=new ContactHomePage();
            this.contactHomePageMyContactPage= new ContactHomePageMyContactPage();
            this.contactEditPage= new ContactEditPage();
            this.assetEditPage= new AssetEditPage();
            this.blackListPage=new BlackListPage();
//            this.eventHomePage=new EventHomePage();
            this.campaignHomePage=new CampaignHomePage();
//            this.kpiHomePage=new KPIHomePage();
            this.families=new Families();
//            this.attributes=new Attributes();
//            this.users=new Users();
            this.connectorHomePage= new ConnectorHomePage();
//            this.userHomePage= new UserHomePage();
//            this.usersLogs= new UsersLogs();
            this.accountHomePage=new AccountHomePage();
//            this.productHomePage=new ProductHomePage();
            this.giftHomePage=new GiftHomePage();
            this.currenciesPage = new CurrenciesPage();
            this.giftHomePage=new GiftHomePage();
            this.tagsPage=new TagsPage();
//            this.importPage=new Import();
        this.modulFlows = new ModulFlows();
        this.taskList = new TaskList();
        this.offstand = new Offstand();
        this.editItemPage= new EditItemPage();
        this.generalPage = new GeneralPage();
        this.menuFlows = new MenuFlows();
        this.panel = new Panel();
        this.itemOverviewPage = new ItemOverviewPage();
        this.dbProcess = new DbProcess();
        this.tableEditorPage = new TableEditorPage();
        this.reportPage = new ReportPage();
        this.message = new Message();
        this.membershipAccountRulePage = new Membership_AccountRulePage();
    }
    // Getter metotları
    public HomePage homePage() {
        return homePage;
    }
    public LoginPage loginPage(){
        return loginPage;
    }
    public Contract contract(){ return contract;}
    public Asset asset() {return asset;}
    public Gift gift(){return gift;}
    public ContactHomePage contactHomePage(){ return contactHomePage;}
    public ContactHomePageMyContactPage contactHomePageMyContactPage(){return contactHomePageMyContactPage;}
    public ContactEditPage contactEditPage(){return contactEditPage;}
    public AssetEditPage assetEditPage(){return assetEditPage;}
    public BlackListPage blackListPage(){return blackListPage;}
//    public EventHomePage eventHomePage(){return eventHomePage;}
    public CampaignHomePage campaignHomePage(){return campaignHomePage;}
//    public KPIHomePage kpiHomePage(){return kpiHomePage;}
    public Families families(){return families;}
//    public Attributes attributes(){return attributes;}
//    public  Users users(){return users;}
    public ConnectorHomePage connectorHomePage(){return connectorHomePage;}
//    public UserHomePage userHomePage(){return userHomePage;}
//    public UsersLogs userLogs(){return usersLogs;}
    public AccountHomePage accountHomePage(){return accountHomePage;}
//    public ProductHomePage productHomePage(){return productHomePage;}
    public GiftHomePage giftHomePage(){return giftHomePage;}
    public CurrenciesPage currenciesPage(){return currenciesPage;}
    public TagsPage tagsPage(){return tagsPage;}
//    public Import importPage(){return importPage;}
    public ModulFlows modulFlows() {return modulFlows;}
    public TaskList taskList() {return taskList;}
    public Offstand offstand() {return offstand;}
    public EditItemPage editItemPage() {return editItemPage;}
    public GeneralPage generalPage() {return  generalPage;}
    public MenuFlows menuFlows() {return menuFlows;}
    public Panel panel() {return panel;}
    public ItemOverviewPage itemOverviewPage(){return itemOverviewPage;}
    public DbProcess dbProcess() {return  dbProcess;}
    public TableEditorPage tableEditorPage() {return  tableEditorPage;}
    public ReportPage reportPage() {return reportPage;}
    public Message message() {return  message;}
    public Membership_AccountRulePage membershipAccountRulePage(){return membershipAccountRulePage;}


}



