# Virtual-Machine-allocation-using-WISWCS

This repository has the code for the implementation of efficient virtual machine allocation using Weighted Interval Scheduling With Capacity Sharing (WISWCS). 
Final simulation was done on the CloudSim environment.

The following IEEE paper has been implemented: An Efficient Method for Maximizing Total Weights in Virtual Machines Allocation
Link: http://ieeexplore.ieee.org/document/6821034/

WICSproject.java -- This file contains the normal java code for the Weighted Interval Scheduling With Capacity Sharing (WISWCS) algorithm.

Replace the following files in the cloudsim-3.0.3 folder:

1) WICS.java
> Place this in cloudsim-3.0.3/examples/org/cloudbus/cloudsim/examples folder.
> This is the main class from which WISWCS algorithm would be run.

2) Cloudlet.java
> Replace this file with its orignal file in cloudsim-3.0.3/sources/org/cloudbus/cloudsim folder.
> This file has additional changes such as - addition of a new attributes in Cloudlet class according to the requirements of the WISWCS algorithm. 

3) DatacenterBroker.java
> Replace this file with its orignal file in cloudsim-3.0.3/sources/org/cloudbus/cloudsim folder.
> This file has the code for allocation of cloudlets to virtual machines according to WISWCS alorithm.
