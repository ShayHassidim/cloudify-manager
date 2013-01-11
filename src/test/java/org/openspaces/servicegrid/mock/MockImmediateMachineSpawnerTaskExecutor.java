package org.openspaces.servicegrid.mock;

import org.openspaces.servicegrid.Task;
import org.openspaces.servicegrid.TaskExecutorState;
import org.openspaces.servicegrid.TaskExecutorStateModifier;
import org.openspaces.servicegrid.agent.state.AgentState;
import org.openspaces.servicegrid.agent.tasks.StartMachineTask;

public class MockImmediateMachineSpawnerTaskExecutor {

	private final TaskExecutorState state = new TaskExecutorState();
	
	public void execute(Task task,
			TaskExecutorStateModifier impersonatedStateModifier) {
		if (task instanceof StartMachineTask) {
			//Simulate starting machine
			AgentState impersonatedState = impersonatedStateModifier.getState();
			impersonatedState.setProgress(AgentState.Progress.STARTING_MACHINE);
			impersonatedStateModifier.updateState(impersonatedState);
			//Immediately machine start 
			impersonatedStateModifier.getState();
			impersonatedState.setProgress(AgentState.Progress.MACHINE_STARTED);
			impersonatedStateModifier.updateState(impersonatedState);
		}
	}

	public TaskExecutorState getState() {
		return state;
	}

}
