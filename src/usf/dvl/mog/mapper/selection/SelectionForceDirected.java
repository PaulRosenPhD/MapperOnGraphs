package usf.dvl.mog.mapper.selection;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;
import usf.dvl.graph.Graph;
import usf.dvl.graph.Graph.GraphVertex;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayout;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutFrame;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutVertex;
import usf.dvl.graph.layout.forcedirected.force.BasicForce;
import usf.dvl.graph.layout.forcedirected.force.BasicForce.PairwiseForce;
import usf.dvl.graph.mapper.Mapper.MapperVertex;
import usf.dvl.graph.mapper.filter.Filter;
import usf.dvl.graph.layout.forcedirected.force.LinearAttractiveForceSet;
import usf.dvl.graph.layout.forcedirected.force.SpringAttractiveForceSet;
import usf.dvl.mog.PAppletMOG;
import usf.dvl.mog.frames.GraphFrame;
import usf.dvl.mog.frames.MapperFrame;
import usf.dvl.graph.layout.forcedirected.force.BasicForce;

public class SelectionForceDirected extends GraphFrame{
	
	protected int selectedPoint = -1;
	protected float unmapX = -1;
	protected float unmapY = -1;
	protected float _otheru0, _otherv0, _otherW, _otherH;
	
	protected ArrayList<GraphVertex> cc = new ArrayList<GraphVertex>();
	protected ArrayList<ForceDirectedLayoutVertex> verts =  new ArrayList<ForceDirectedLayoutVertex>();
		
	private MapperFrame selectedMapper = null;
	private MapperVertex selectedMapperVertex = null;
	private GraphVertex selectedMapperVertices = null;
	protected ArrayList<MapperFrame> frameList = null;
	
	// made a new force set
	private SpringAttractiveForceSet Springs = new SpringAttractiveForceSet(this.fdl, 1);
	
	// trying this out with a hashmap and a boolean
	private HashMap<GraphVertex, SpringAttractiveForceSet> SpringCollection = new HashMap<GraphVertex, SpringAttractiveForceSet>();
	
//	public SelectionForceDirected(PApplet p, Graph _g, Filter _filter, int resolution, float eps ) {
//		super( p, _g );
//		
//		this.SF = new SelectionFrame( p, _g, _filter, resolution, eps, this );
//	}
	
	// constructor
	
	public SelectionForceDirected( PApplet p, Graph _g, ArrayList<MapperFrame> frameList)
	{
		super( p, _g);
	}
	
	
	
	/****
	 
	 I hope I can just start from the beginning and find out what I need
	 */
	
	
	
//	public SelectionForceDirected( PApplet p, Graph _g, ArrayList<MapperFrame> frameList)
//	{
//		super( p, _g ); 
//		this.frameList = frameList;
//		
//		// populate the verts here
////		System.out.println(this.selectedMapper.getGraph().getNodeCount());
//
//		// create springs here in the constructor
//		for (ForceDirectedLayoutVertex g : verts)
//		{
//			fdl.addForce( Springs.addSpring( fdl.getVertex(this.selectedPoint), g) );
//		}
//		
//	}
//	
//	// overloaded again for fix ?
////	public SelectionForceDirected( PApplet p, Graph _g)
////	{
////		super( p, _g);
////	}
//	
//	//public void receiveSF( SelectionFrame SF ) { this.SF = SF; }
//	
//	public void setSelectedMapper0( MapperFrame selectedMapper0 ) { this.selectedMapper = selectedMapper0; }
//
//	
//	@Override
//	public void update()
//	{
//		super.update();
//		
//		if ( PAppletMOG.selectedVertex != null )
//		{
//			this.selectedPoint = this.selectedMapper.getFDL().getSelectedPoint();
//			
//			// not sure if a race condition is causing an exception to be thrown
//			if ( this.selectedPoint >= 0 )
//			{
//				this.selectedMapperVertex = (MapperVertex) this.selectedMapper.getMapperG().nodes.get(this.selectedPoint);
//		
//			}
//		}
//
//		// will probably need this statement
////		if (selectedMapper0 != null && selectedMapper1 != null)
////		{
////		
////		}
////		if ( this.selectedMapper0 != null ) { this.selectedMapper0Vertices = this.selectedMapper0.get}
//		
////		try
////		{
////			System.out.println();
////		}
////		catch( Exception e)
////		{
////			System.out.println("None");
////		}
//		if ( this.selectedPoint >= 0 )
//		{
//			this.cc.clear();
//			this.cc.addAll( this.selectedMapperVertex.cc );
//			ArrayList<ForceDirectedLayoutVertex> layoutverts = this.fdl.getLayoutVerts();
//			
//			for ( GraphVertex g : this.cc )
//			{
//				try
//				{
//					this.verts.add(layoutverts.get( selectedMapper.getGraph().getVertexIndex(g )) );
//				}
//				catch(Exception e) { e.printStackTrace(); }
//			}
//			
//			calculateMapMouse();
//			// this combination works: map using the frame dimensions and unmap to the graph space
////			this.unmapX = PApplet.map(this.unmapX, this._otheru0, this._otherW, 0, 895);
////			this.unmapY = PApplet.map(this.unmapY, this._otherH, this._otherv0, 900, 0);
//			
//			// using the dimensions of the frame itself
//			// commented because I wrote a function for it at the bottom
////			this.unmapX = PApplet.map(this.unmapX, this._otheru0, this._otherW, 0, this.w);
////			this.unmapY = PApplet.map(this.unmapY, this._otherH, this._otherv0, this.h, 0);			
////			
////			this.unmapX = super.unmapX( this.unmapX );
////			this.unmapY = super.unmapY( this.unmapY );
//
//			// disabled because I don't need it to track my mouse position
////			super.fdl.setVertexPosition(this.selectedPoint, this.unmapX, this.unmapY);
//			
//			if ( !this.verts.isEmpty() )
//			{
//				System.out.println("Adding " + this.selectedPoint );
////				fdl.addForces( new SelectionLinearAttractiveForceSet(this.fdl, this.unmapX, this.unmapY, this.verts) );
//				for (ForceDirectedLayoutVertex g : verts )
//				{
////					fdl.addForce( new CoverPairwise( this.fdl.getVertex(this.selectedPoint), g) );
//					
//					// this is where I add the springs for the nodes connected
//					// toggling this off so I can add it once in the constructor
//					//fdl.addForce( Springs.addSpring( fdl.getVertex(this.selectedPoint), g) );
//				}
//				
//			}
//
//		}
//		
//		this.selectedPoint = -1;
//		this.selectedMapperVertex = null;
//	}
//	
//	@Override
//	public void draw() { super.draw(); }
//	
//	public void calculateMapMouse()
//	{
//		float mouseX = PApplet.constrain( papplet.mouseX, this.selectedMapper.getFDL().getU0(), this.selectedMapper.getFDL().getU0() + super.fdl.getWidth() );
//		float mouseY = PApplet.constrain( papplet.mouseY, this.selectedMapper.getFDL().getV0(), this.selectedMapper.getFDL().getV0() + super.fdl.getHeight() );
//		
//		float mapperU0 = this.selectedMapper.getU0();
//		float mapperV0 = this.selectedMapper.getV0();
//		float mapperW = this.selectedMapper.getU0() + this.selectedMapper.getWidth();
//		float mapperH = this.selectedMapper.getV0() + this.selectedMapper.getHeight();
//		
//		this.unmapX = PApplet.map(mouseX, mapperU0, mapperW, 0, this.w);
//		this.unmapY = PApplet.map(mouseY, mapperH, mapperV0, this.h, 0);			
//		
//		this.unmapX = super.unmapX( this.unmapX );
//		this.unmapY = super.unmapY( this.unmapY );
//	}
	
	
	
	
	
}
