/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ivory.rerun.event;

import org.apache.ivory.workflow.engine.WorkflowEngine;

public class RetryEvent extends RerunEvent {

	private int attempts;
	private int failRetryCount;

	public RetryEvent(WorkflowEngine wfEngine, String clusterName, String wfId,
			long msgInsertTime, long delay, String processName,
			String processInstance, int runId, int attempts, int failRetryCount) {
		super(wfEngine, clusterName, wfId, msgInsertTime, delay, processName,
				processInstance, runId);
		this.attempts = attempts;
		this.failRetryCount = failRetryCount;
	}

	public int getAttempts() {
		return attempts;
	}

	public int getFailRetryCount() {
		return failRetryCount;
	}

	public void setFailRetryCount(int failRetryCount) {
		this.failRetryCount = failRetryCount;
	}

	@Override
	public String toString() {
		return clusterName + SEP + wfId + SEP + msgInsertTime + SEP
				+ delayInMilliSec + SEP + processName + SEP + processInstance
				+ SEP + runId + SEP + attempts + SEP + failRetryCount;
	}

}