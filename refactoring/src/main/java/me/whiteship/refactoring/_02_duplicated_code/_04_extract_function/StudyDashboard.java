package me.whiteship.refactoring._02_duplicated_code._04_extract_function;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudyDashboard {

    private void printParticipants(int eventId) throws IOException {
        print(getUsernames(getGhIssue(eventId)));
    }

    private void print(Set<String> participants) {
        participants.forEach(System.out::println);
    }

    private Set<String> getUsernames(GHIssue issue) throws IOException {
        issue.getComments().forEach(c -> ((Set<String>) new HashSet<String>()).add(c.getUserName()));
        return new HashSet<>();
    }

    private GHIssue getGhIssue(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        return repository.getIssue(eventId);
    }

    private void printReviewers() throws IOException {
        GHIssue issue = getGhIssue(30);
        print(getUsernames(issue));
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }

}
