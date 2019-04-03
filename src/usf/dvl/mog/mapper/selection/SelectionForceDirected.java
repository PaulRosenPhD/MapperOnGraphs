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
	private SpringAttractiveForceSet Springs = new SpringAttractiveForceSet(this.fdl, 15);
//	protected LinearAttractiveForceSet forceSLA = null;
//	protected SpringAttractiveForceSet forceSAF = null;
//	protected ForceDirectedLayout selectedFDL = null;
	
	public SelectionForceDirected(PApplet p, Graph _g ) {
		super( p, _g );
//		verts = this.fdl.getLayoutVerts();
		
	}
	
	//public void receiveSF( SelectionFrame SF ) { this.SF = SF; }
	
	@Override
	public void update()
	{
		// this.u0 is correct for this layout
//		System.out.println(papplet.mouseX + " " + this.u0 + " " + ( this.u0 + this.w) );
		
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

			
//			System.out.println(super.fdl.getVertex(this.selectedPoint).getPositionX() + " " + super.fdl.getVertex(this.selectedPoint).getPositionY());
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
//			System.out.println(this.unmapX);
			//System.out.println("Before " + super.fdl.getVertex(this.selectedPoint).getPositionX() + " " + super.fdl.getVertex(this.selectedPoint).getPositionY() );
			super.fdl.setVertexPosition(this.selectedPoint, this.unmapX, this.unmapY);
			
			if ( !this.verts.isEmpty() )
			{
			
//				fdl.addForces( new SelectionLinearAttractiveForceSet(this.fdl, this.unmapX, this.unmapY, this.verts) );
				for (ForceDirectedLayoutVertex g : verts )
				{
//					fdl.addForce( new CoverPairwise( this.fdl.getVertex(this.selectedPoint), g) );
					fdl.addForce( Springs.addSpring( fdl.getVertex(this.selectedPoint), g) );
				}
				
			}
			
			//System.out.println("After " + super.fdl.getVertex(this.selectedPoint).getPositionX() + " " + super.fdl.getVertex(this.selectedPoint).getPositionY() );
//			System.out.println(this.unmapX + " " + this.unmapY);
			
//			System.out.println("Exited");
			
			
//			_g.nodes = this.cc;
//			
//			
//			this.selectedFDL = new ForceDirectedLayout(_g, this.w, this.h);
//			
//			this.forceSLA = new LinearAttractiveForceSet(this.selectedFDL, this.unmapX, this.unmapY, 999999f);
//
//			
//			this.forceSAF = new SpringAttractiveForceSet( this.selectedFDL);
//			// why doesn't this work ?
//			super.fdl.addForces( this.forceSLA );
//			super.fdl.addForces( this.forceSAF );
//			super.forceSLA.addAll( this.forceSLA );
//			super.forceSAF.addAll( this.forceSAF );
//			super.forceSLA.addAll(this.selectedPoint, this.forceSLA);
//			super.forceSAF.addAll(this.selectedPoint, this.forceSAF);
			
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
