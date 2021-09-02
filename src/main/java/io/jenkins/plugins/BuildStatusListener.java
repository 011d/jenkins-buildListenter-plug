package io.jenkins.plugins;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.model.listeners.RunListener;

@Extension
public class BuildStatusListener extends RunListener<Run<?,?>> {

    @Override
    public void onStarted(Run<?,?> run, TaskListener listener) {
        BuildStatusAction action = run.getAction(BuildStatusAction.class);
        System.out.println("onStarted action: "+action);
        if (action == null) {
            return;
        }
    }

    @Override
    public void onCompleted(Run<?,?> run,  @NonNull TaskListener listener) {
        BuildStatusAction action = run.getAction(BuildStatusAction.class);
        System.out.println("onCompleted action: "+action);
        System.out.println("id: "+run.getId());
        System.out.println("name: "+run.getParent().getName());
        System.out.println("nextBuildNumber: "+run.getParent().getNextBuildNumber());
        if (action == null) {
            return;
        }
    }
}
