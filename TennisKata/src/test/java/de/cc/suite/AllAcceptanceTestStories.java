package de.cc.suite;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import de.cc.TennisGameSteps;

/**
 * <p>
 * {@link Embeddable} class to run multiple textual stories via JUnit.
 * </p>
 * <p>
 * Stories are specified in classpath and correspondingly the
 * {@link LoadFromClasspath} story loader is configured.
 * </p>
 */

public class AllAcceptanceTestStories extends JUnitStories {

	public AllAcceptanceTestStories() {
		super();
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new TennisGameSteps());
	}

	@Override
	public Configuration configuration() {

		return new MostUsefulConfiguration()
				.useStoryReporterBuilder(new StoryReporterBuilder()
						.withFormats(Format.STATS));
		// .useStoryReporterBuilder(new StoryReporterBuilder()
		// .withFormats(Format.CONSOLE,Format.HTML,Format.XML));
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("de/cc/TennisGameStory.story");
	}
}
