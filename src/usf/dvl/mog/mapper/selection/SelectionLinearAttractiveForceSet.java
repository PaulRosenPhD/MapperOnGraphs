package usf.dvl.mog.mapper.selection;

import usf.dvl.graph.layout.forcedirected.ForceDirectedLayout;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutVertex;
import usf.dvl.graph.layout.forcedirected.force.LinearAttractiveForceSet;
import java.util.ArrayList;
import usf.dvl.graph.Graph;
import usf.dvl.graph.Graph.GraphVertex;


public class SelectionLinearAttractiveForceSet extends usf.dvl.graph.layout.forcedirected.force.LinearAttractiveForceSet {

	public float centroidX = 0;
	public float centroidY = 0;
	protected ArrayList<ForceDirectedLayoutVertex> cc = null;
	
	SelectionLinearAttractiveForceSet( ForceDirectedLayout _fdl, float _centroidX, float _centroidY)
	{
		super(_fdl, _centroidX, _centroidY);
	}
	
	SelectionLinearAttractiveForceSet( ForceDirectedLayout _fdl, float _centroidX, float _centroidY, float _pullScaleFactor)
	{
		super( _fdl, _centroidX, _centroidY );
	}
	
	SelectionLinearAttractiveForceSet( ForceDirectedLayout _fdl, float _centroidX, float _centroidY, ArrayList<ForceDirectedLayoutVertex> cc)
	{
		super( _fdl, _centroidX, _centroidY);
		// x and y of selected point
		this.centroidX = _centroidX;
		this.centroidY = _centroidY;
		this.cc = cc;
		
		for (ForceDirectedLayoutVertex g : cc)
		{
			super.add( new LinearAttractiveForce( g) );
		}
	}
	
	
	
//	public void addSelectedNodeAttraction(float selectedX, float selectedY, ArrayList<GraphVertex> cc)
//	{
//		this.selectedX = selectedX;
//		this.selectedY = selectedY;
//		this.cc = cc;
//		
//		
//	}
//	public void removeSelectedNodeAttraction()
//	{
//		this.selectedX = 0;
//		this.selectedY = 0;
//		this.cc = null;
//	}
}
