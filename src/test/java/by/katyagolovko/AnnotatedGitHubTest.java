package by.katyagolovko;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedGitHubTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUES_TAB = "Issues";
    private final static String ISSUE_NAME = "69 nice";

    @Test
    @DisplayName("Проверяем название первого Issue в списке " + ISSUE_NAME)
    public void shouldFindNameOfTheFirstIssue(){
        AllSteps steps = new AllSteps();
        steps.openMainPage();
        steps.findRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToTab(ISSUES_TAB);
        steps.verifyNameOfTheFirstIssue(ISSUE_NAME);
    }
}
