package usf.dvl.mog.mapper.selection;

import usf.dvl.graph.layout.forcedirected.ForceDirectedLayout;
import usf.dvl.graph.layout.forcedirected.force.LinearAttractiveForceSet;
import java.util.ArrayList;
import usf.dvl.graph.Graph;
import usf.dvl.graph.Graph.GraphVertex;


public class SelectionLinearAttractiveForceSet extends usf.dvl.graph.layout.forcedirected.force.LinearAttractiveForceSet {

	public float selectedX = 0;
	public float selectedY = 0;
	protected ArrayList<GraphVertex> cc = null;
	SelectionLinearAttractiveForceSet( ForceDirectedLayout _fdl, float _centroidX, float _centroidY)
	{
		super(_fdl, _centroidX, _centroidY);
	}
	
	
	public void addSelectedNodeAttraction(float selectedX, float selectedY, ArrayList<GraphVertex> cc)
	{
		this.selectedX = selectedX;
		this.selectedY = selectedY;
		this.cc = cc;
		
		
	}
	public void removeSelectedNodeAttraction()
	{
		this.selectedX = 0;
		this.selectedY = 0;
		this.cc = null;
	}
}
