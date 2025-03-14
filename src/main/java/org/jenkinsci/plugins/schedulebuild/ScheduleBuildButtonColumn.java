package org.jenkinsci.plugins.schedulebuild;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.Job;
import hudson.model.TopLevelItem;
import hudson.views.ListViewColumn;
import hudson.views.ListViewColumnDescriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest2;

public class ScheduleBuildButtonColumn extends ListViewColumn {

    public boolean isBuildable(TopLevelItem item) {
        return item instanceof Job;
    }

    public static final class DescriptorImpl extends ListViewColumnDescriptor {
        @Override
        public String getDisplayName() {
            return Messages.ScheduleBuildButtonColumn_DisplayName();
        }

        @Override
        public ListViewColumn newInstance(final StaplerRequest2 request, final JSONObject formData)
                throws FormException {
            return new ScheduleBuildButtonColumn();
        }

        @Override
        public boolean shownByDefault() {
            return true;
        }
    }

    @Extension
    public static final Descriptor<ListViewColumn> DESCRIPTOR = new DescriptorImpl();

    @Override
    public Descriptor<ListViewColumn> getDescriptor() {
        return DESCRIPTOR;
    }
}
