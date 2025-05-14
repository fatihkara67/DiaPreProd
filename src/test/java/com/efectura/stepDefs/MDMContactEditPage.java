package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MDMContactEditPage extends BaseStep {
    public MDMContactEditPage() {
    }

    @When("The user clicks upload button")
    public void the_user_clicks_upload_button() {
        pages.contactEditPage().clickUploadButtonAndUploadFile();
    }

    @Then("The user verifies the photo uploaded")
    public void the_user_verifies_the_photo_uploaded() {
        pages.contactEditPage().verifyUpload();
    }

    @When("The user enters {string} in  comment area")
    public void the_user_enters_in_comment_area1(String comment) {
        pages.contactEditPage().setChangeCommentArea(comment);
    }

    @When("The user enters {string} in comment area")
    public void the_user_enters_in_comment_area(String comment) {
        BrowserUtils.waitForVisibility(pages.generalPage().getChangeSaveCommentTextArea(),15);
        pages.generalPage().getChangeSaveCommentTextArea().sendKeys(comment);
    }

    @When("The user clicks upload photo cancel button")
    public void the_user_clicks_upload_photo_cancel_button() {
        pages.contactEditPage().clickUploadPhotoCancelButton();
    }

    @Then("The user verifies the photo unuploaded")
    public void the_user_verifies_the_photo_unuploaded() {
        pages.contactEditPage().verifyUnUpload();
    }

    @When("The user clicks upload photo save button")
    public void the_user_clicks_upload_photo_save_button() {
        pages.contactEditPage().clickUploadPhotoSaveButton();
    }

    @When("The user clicks upload photo save  button")
    public void the_user_clicks_upload_photo_save1_button() {
        pages.contactEditPage().clickUnSavedButton();
    }

//    @Then("The user selects {string}")
//    public void the_user_selects(String status) {
//        pages.assetEditPage().selectItemStatusInAssetEditPage(status);
//    }

    @Then("the user clicks on unsaved change button")
    public void the_user_clicks_on_unsaved_change_button() {
        pages.contactEditPage().clickUnSavedButton();
    }

    @Then("The user clicks save button")
    public void the_user_clicks_save_button() {
        pages.contactEditPage().clickSaveChangeButton();
    }

    @Given("^the user verifies item status success message$")
    public void theUserVerifiesItemStatusSuccessMessage() {
        pages.contactEditPage().verifyChangeSuccessMessage();

    }

    @Given("^The user clicks cancel button$")
    public void theUserClicksCancelButton() {
        pages.contactEditPage().clickCancelChangeButton();
    }

    @Given("^the user verifies item status not change$")
    public void theUserVerifiesItemStatusNotChange() {
        pages.contactEditPage().verifyCancelChange();

    }

    @Then("The user clicks new list item-contact")
    public void the_user_clicks_new_list_item() {
        pages.contactEditPage().clickListItem();
    }

    @Then("The user clicks Export PDF button")
    public void the_user_clicks_export_pdf_button() {
        pages.contactEditPage().clickExportPDF();
    }

    @Then("The user clicks Refresh button")
    public void the_user_clicks_refresh_button() {
        pages.contactEditPage().clickRefreshButton();
    }

    @Then("The user verifies the file is downloaded")
    public void the_user_verifies_the_file_is_downloaded() {

    }

    @Then("The user verifies refresh button")
    public void the_user_verifies_refresh_button() {

    }


}
