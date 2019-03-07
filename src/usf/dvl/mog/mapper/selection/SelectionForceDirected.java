package usf.dvl.mog.mapper.selection;

import java.util.ArrayList;

import processing.core.PApplet;
import usf.dvl.graph.Graph;
import usf.dvl.graph.Graph.GraphVertex;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayout;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutFrame;
import usf.dvl.graph.layout.forcedirected.force.BasicForce;
import usf.dvl.graph.layout.forcedirected.force.LinearAttractiveForceSet;
import usf.dvl.graph.layout.forcedirected.force.SpringAttractiveForceSet;
import usf.dvl.mog.frames.GraphFrame;

public class SelectionForceDirected extends GraphFrame{

	//protected SelectionFrame SF = null;
	
	protected int selectedPoint = -1;
	protected float unmapX = -1;
	protected float unmapY = -1;
	protected float _otheru0, _otherv0, _otherW, _otherH;
	
	//forces
	protected Graph _g = new Graph();
	protected ArrayList<GraphVertex> cc = new ArrayList<GraphVertex>();
	protected LinearAttractiveForceSet forceSLA = null;
	protected SpringAttractiveForceSet forceSAF = null;
	protected ForceDirectedLayout selectedFDL = null;
	
	public SelectionForceDirected(PApplet p, Graph _g ) {
		super( p, _g );
		
	}
	
	//public void receiveSF( SelectionFrame SF ) { this.SF = SF; }
	
	// I don't know why I only need to map Y
	@Override
	public void update()
	{
		super.update();
		if ( this.selectedPoint >= 0 )
		{
//			this.unmapX = super.mapX(this.unmapX );
//			this.unmapY = super.mapY(this.unmapY );
			
//			this.unmapX = super.mapX(this.unmapX + this._otheru0);
//			this.unmapY = super.mapY(this.unmapY + this._otherv0);
//			
//			this.unmapX = super.mapX(this.unmapX - this._otheru0);
//			this.unmapY = super.mapY(this.unmapY - this._otherv0);			
			
			this.unmapX = this.unmapX(this.unmapX - this.u0);
			this.unmapY = this.unmapY(this.unmapY - this.v0);
//			System.out.println("X");
//			System.out.println(this.unmapX);

//			this.unmapX = PApplet.map(this.unmapX, this._otheru0, this._otherW,
//					this.u0, this.w);
//			System.out.println(this.unmapX);
			
//			System.out.println("Y");
//			System.out.println(this.unmapY);
//			this.unmapY = PApplet.map(this.unmapY, this._otherH, this._otherv0,
//					this.h, this.v0);
//			System.out.println(this.unmapY);
//			System.out.println("Entered");
			
			// unmap x and y before setting
			super.fdl.setVertexPosition(this.selectedPoint, this.unmapX, this.unmapY);
//			System.out.println("Exited");
			
			
			_g.nodes = this.cc;
			
			this.selectedFDL = new ForceDirectedLayout(_g, this.w, this.h);
//			System.out.println(_g.getNodeCount() + " " + _g.getEdgeCount() );
			
			this.forceSLA = new LinearAttractiveForceSet(this.selectedFDL, this.unmapX, this.unmapY, 999999f);
//			System.out.println(this.forceSLA.pullScaleFactor);
			
			this.forceSAF = new SpringAttractiveForceSet( this.selectedFDL);
			// why doesn't this work ?
			super.fdl.addForces( this.forceSLA );
			super.fdl.addForces( this.forceSAF );
			super.forceSLA.addAll( this.forceSLA );
			super.forceSAF.addAll( this.forceSAF );
			super.forceSLA.addAll(this.selectedPoint, this.forceSLA);
			super.forceSAF.addAll(this.selectedPoint, this.forceSAF);
			
//			for ( GraphVertex _v : this.cc)
//			{
//				super.fdl.setVertexPosition( g.getVertexIndex( _v), this.unmapX, this.unmapY);
//			}

		}
		this.selectedPoint = -1;
	}
	
	@Override
	public void draw()
	{
		super.draw();
		
		
	}
	
	
//	public void applySpringForce( GraphVertex center )
//	{
//		ArrayList<GraphVertex> adj = (ArrayList<GraphVertex>) center.getAdjacentVertices();
//		float RESTING_LENGTH = 1.0f;   
//		float SPRING_SCALE   = 0.05f; 
//		float REPULSE_SCALE  = 450.0f;
//		float TIME_STEP      = 0.30f;
//		
//		float force = SPRING_SCALE;
//	}

}
