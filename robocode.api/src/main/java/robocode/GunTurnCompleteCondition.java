/*******************************************************************************
 * Copyright (c) 2001-2012 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 *
 * Contributors:
 *     Mathew A. Nelson
 *     - Initial API and implementation
 *     Flemming N. Larsen
 *     - Updated Javadocs
 *     Nathaniel Troutman
 *     - Added cleanup() method for cleaning up references to internal classes
 *       to prevent circular references causing memory leaks
 *******************************************************************************/
package robocode;


/**
 * A prebuilt condition you can use that indicates your gun has finished
 * turning.
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 * @author Nathaniel Troutman (contributor)
 * @see Condition
 */
public class GunTurnCompleteCondition extends Condition {
	private AdvancedRobot robot = null;

	/**
	 * Creates a new GunTurnCompleteCondition with default priority.
	 * The default priority is 80.
	 *
	 * @param robot your robot, which must be a {@link AdvancedRobot}
	 */
	public GunTurnCompleteCondition(AdvancedRobot robot) {
		super();
		this.robot = robot;
	}

	/**
	 * Creates a new GunTurnCompleteCondition with a specific priority.
	 * A condition priority is a value from 0 - 99. The higher value, the
	 * higher priority. The default priority is 80.
	 *
	 * @param robot	your robot, which must be a {@link AdvancedRobot}
	 * @param priority the priority of this condition
	 * @see Condition#setPriority(int)
	 */
	public GunTurnCompleteCondition(AdvancedRobot robot, int priority) {
		super();
		this.robot = robot;
		this.priority = priority;
	}

	/**
	 * Tests if the gun has stopped turning.
	 *
	 * @return {@code true} if the gun has stopped turning; {@code false}
	 *         otherwise
	 */
	@Override
	public boolean test() {
		return (robot.getGunTurnRemaining() == 0);
	}

	/**
	 * Called by the system in order to clean up references to internal objects.
	 *
	 * @since 1.4.3
	 */
	@Override
	public final void cleanup() {
		robot = null;
	}
}
