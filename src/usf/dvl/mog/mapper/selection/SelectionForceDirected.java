package usf.dvl.mog.mapper.selection;

import java.util.ArrayList;

import processing.core.PApplet;
import usf.dvl.graph.Graph;
import usf.dvl.graph.Graph.GraphVertex;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayout;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutFrame;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutVertex;
import usf.dvl.graph.layout.forcedirected.force.BasicForce;
import usf.dvl.graph.layout.forcedirected.force.BasicForce.PairwiseForce;
import usf.dvl.graph.layout.forcedirected.force.LinearAttractiveForceSet;
import usf.dvl.graph.layout.forcedirected.force.SpringAttractiveForceSet;
import usf.dvl.mog.frames.GraphFrame;
import usf.dvl.graph.layout.forcedirected.force.BasicForce;

public class SelectionForceDirected extends GraphFrame{

	//protected SelectionFrame SF = null;
	
	protected int selectedPoint = -1;
	protected float unmapX = -1;
	protected float unmapY = -1;
	protected float _otheru0, _otherv0, _otherW, _otherH;
	
	//forces
//	protected Graph _g = new Graph();
	protected ArrayList<GraphVertex> cc = new ArrayList<GraphVertex>();
	protected ArrayList<ForceDirectedLayoutVertex> verts =  new ArrayList<ForceDirectedLayoutVertex>();
	
	// made a new force set
	private SpringAttractiveForceSet Springs = new SpringAttractiveForceSet(this.fdl, 1);
	
	public SelectionForceDirected(PApplet p, Graph _g ) {
		super( p, _g );
		
	}
	
	//public void receiveSF( SelectionFrame SF ) { this.SF = SF; }
	
	@Override
	public void update()
	{

		
		super.update();
		if ( this.selectedPoint >= 0 )
		{

			// this combination works: map using the frame dimensions and unmap to the graph space
//			this.unmapX = PApplet.map(this.unmapX, this._otheru0, this._otherW, 0, 895);
//			this.unmapY = PApplet.map(this.unmapY, this._otherH, this._otherv0, 900, 0);
			
			// using the dimensions of the frame itself
			this.unmapX = PApplet.map(this.unmapX, this._otheru0, this._otherW, 0, this.w);
			this.unmapY = PApplet.map(this.unmapY, this._otherH, this._otherv0, this.h, 0);			
			
			this.unmapX = super.unmapX( this.unmapX );
			this.unmapY = super.unmapY( this.unmapY );

			// disabled because I don't need it to track my mouse position
//			super.fdl.setVertexPosition(this.selectedPoint, this.unmapX, this.unmapY);
			
			if ( !this.verts.isEmpty() )
			{
				System.out.println("Adding " + this.selectedPoint );
//				fdl.addForces( new SelectionLinearAttractiveForceSet(this.fdl, this.unmapX, this.unmapY, this.verts) );
				for (ForceDirectedLayoutVertex g : verts )
				{
//					fdl.addForce( new CoverPairwise( this.fdl.getVertex(this.selectedPoint), g) );
					fdl.addForce( Springs.addSpring( fdl.getVertex(this.selectedPoint), g) );
				}
				
			}

		}
		
		this.selectedPoint = -1;
	}
	
	@Override
	public void draw() { super.draw(); }
	

}
