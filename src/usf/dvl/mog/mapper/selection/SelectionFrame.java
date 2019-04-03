package usf.dvl.mog.mapper.selection;

import java.util.ArrayList;

import usf.dvl.graph.Graph;
import usf.dvl.graph.Graph.GraphEdge;
import usf.dvl.graph.Graph.GraphVertex;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutFrame;
import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutVertex;
import usf.dvl.graph.mapper.Mapper;
import usf.dvl.graph.mapper.Mapper.MapperVertex;
import usf.dvl.graph.mapper.filter.Filter;
import usf.dvl.mog.PAppletMOG;
import usf.dvl.mog.frames.GraphFrame;
import usf.dvl.mog.frames.MapperFrame;

//import processing.core.PApplet;
//import usf.dvl.draw.DFrame;
//import usf.dvl.draw.DMultiFrame;
//import usf.dvl.draw.color.SequentialColormap;
//import usf.dvl.graph.Graph;
//import usf.dvl.graph.Graph.GraphEdge;
//import usf.dvl.graph.Graph.GraphVertex;
//import usf.dvl.graph.layout.forcedirected.ForceDirectedLayout;
//import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutFrame;
//import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutVertex;
//import usf.dvl.graph.mapper.Cover;
//import usf.dvl.graph.mapper.Mapper;
//import usf.dvl.graph.mapper.Mapper.MapperVertex;
//import usf.dvl.graph.mapper.filter.Filter;
//import usf.dvl.mog.PAppletMOG;

import java.util.HashMap;
import java.util.Set;

import processing.core.PApplet;


// extends MapperFrame or has function create a new one ?
public class SelectionFrame extends MapperFrame{

//	public GraphVertex selected = null;
//	private ArrayList<GraphVertex> nodes = null;
//	private ArrayList<GraphEdge> edges = null;
//	private ArrayList<GraphVertex> similarNodes = null;
//	private float averageX, averageY;
//	private HashMap <GraphVertex, GraphEdge> mapper = new HashMap<GraphVertex, GraphEdge>();
//	
//	
	
//	private Graph g = null;
	
	protected MapperVertex selected = null; 
//	protected Set<GraphVertex> _cc = null;
	protected ArrayList<GraphVertex> cc = new ArrayList<GraphVertex>();
	protected SelectionForceDirected SFD = null;
	
	protected ArrayList<ForceDirectedLayoutVertex> verts = new ArrayList<ForceDirectedLayoutVertex>();
	
	// not sure if this will work
	protected float unmapX = -1;
	protected float unmapY = -1;
	
	public SelectionFrame( PApplet p, Graph _graph, Filter _filter, int resolution, float eps, SelectionForceDirected SFD ){
		super(p,_graph,_filter, resolution, eps );
		
		this.SFD = SFD;
		//this.SFD.receiveSF( this );
	}
	
	
	@Override
	public void update()
	{
		super.update();
		
		if ( super.fdl.getSelectedPoint() >= 0 )
		{
//			PAppletMOG.selectedFunction = this;
			selected = (Mapper.MapperVertex)super.mapperG.nodes.get( super.fdl.getSelectedPoint() );
//			_cc = selected.cc;
			//super.fdl.fdl.getVertices();
			
			
//			ArrayList<GraphVertex> adj = (ArrayList<GraphVertex>)this.selected.getAdjacentVertices();
			
			// okay I guess this doesn't work
//			for (GraphVertex _v : _cc )
//			{
//				cc.add(_v);
//			}
			cc.clear();
			cc.addAll( selected.cc );
			this.SFD.cc = this.cc;
			

			// this doesn't work the way it's supposed to 20190327
//			System.out.println( cc.size() );

//			ArrayList<ForceDirectedLayoutVertex> layoutverts = super.fdl.fdl.getLayoutVerts();
			verts.clear();
			ArrayList<ForceDirectedLayoutVertex> layoutverts = SFD.fdl.getLayoutVerts();
			//System.out.println(layoutverts.size());

			for ( GraphVertex g : cc)
			{
				// rename

				try
				{
//					verts.add( super.fdl.fdl.getVertex( graph.getVertexIndex( g) ) );
					verts.add(layoutverts.get( graph.getVertexIndex(g )) );
					
				}
				catch(Exception e)
				{
				}
			}
			this.SFD.verts = this.verts;
//			System.out.println(verts.size());
			
			//System.out.println(i);
//			this.SFD.verts = this.verts;
			 //for all, try and make a different color 
//			for (GraphVertex g : selected.cc)
//			{
//				if ( g != null)
//				{
//					this.cc.add(g);
//				}
//			}
//			graph.nodes = (ArrayList<GraphVertex>)selected.cc;
			
			// this works...sort of
			this.unmapX = PApplet.constrain( papplet.mouseX, super.fdl.getU0(), super.fdl.getU0() + super.fdl.getWidth() );
			this.unmapY = PApplet.constrain( papplet.mouseY, super.fdl.getV0(), super.fdl.getV0() + super.fdl.getHeight() );

//			if ( this.unmapX < super.fdl.getU0() ) 						   { this.unmapX = super.fdl.getU0(); }
//			if ( this.unmapX > super.fdl.getU0() + super.fdl.getWidth() )  { this.unmapX = super.fdl.getU0() + super.fdl.getWidth(); }
//			if ( this.unmapY < super.fdl.getV0() ) 						   { this.unmapY = super.fdl.getV0(); }
//			if ( this.unmapY > super.fdl.getV0() + super.fdl.getHeight() ) { this.unmapY = super.fdl.getV0() + super.fdl.getHeight(); }
			
			this.SFD.unmapX = this.unmapX;   
			this.SFD.unmapY = this.unmapY; 
			
			
			// this gets min values, not the vertex position
//			super.fdl.getU0();
//			super.fdl.getV0();
//			super.fdl.getWidth();
//			super.fdl.getHeight();
			
//			System.out.println(super.fdl.fdl.getVertex(super.fdl.getSelectedPoint() ).getPositionX() + " " + super.fdl.fdl.getVertex(super.fdl.getSelectedPoint() ).getPositionY() );
			
//			for (ForceDirectedLayout)
			
			// broke this because I changed unmap back to protected on FDL Frame
//			this.SFD.unmapX =  super.fdl.unmapX(papplet.mouseX-u0);
//			this.SFD.unmapY =  super.fdl.unmapY(papplet.mouseY-v0); 
//			System.out.println(papplet.mouseX + " " + super.fdl.getU0() + " " + (super.fdl.getWidth()) );
			this.SFD._otheru0 = super.fdl.getU0();
			this.SFD._otherv0 = super.fdl.getV0();
			this.SFD._otherW = super.fdl.getU0() + super.fdl.getWidth();
			this.SFD._otherH = super.fdl.getV0() + super.fdl.getHeight();
			
			
			this.SFD.selectedPoint = super.fdl.getSelectedPoint();
			
//			if ( this.SFD.forceSLA != null ) 
//			{
////				super.fdl.fdl.addForces( this.SFD.forceSLA ); 
////				System.out.println("Should've worked");
//
//			}

		}
	}
	
	@Override
	public void draw()
	{
		super.draw();

		// I don't think I need this. I think I was using this to test out functionality to begin with
//		if (this.selected != null)
//		{
//			
//		}

	}

	
	
	
	
	
	
	
	
	
	
	
	/*
	// Graph constructor already contains nodes and edges
	public SelectionFrame(PApplet p, Graph _g) 
	{
		super()
		
		this.nodes = _g.nodes;
		this.edges = _g.edges;
		this.g = _g;
		
		this.selected = PAppletMOG.selectedVertex;

		//if (PAppletMOG.selectedVertex != null) { System.out.println("Selection"); }
//		findSimilarNodes();
		
	}
	
	public SelectionFrame(PAppletMog.selectedVertex selected)
	{
		
	}
	
	
	public SelectionFrame(ArrayList<GraphVertex> nodes)
	{
		this.nodes = nodes;
		// for all nodes in list, use FDL forces
	}
	public SelectionFrame(ArrayList<GraphEdge> edges)
	{
		this.edges = edges;
	}
	
	

	public void setSelected(GraphVertex selected) { this.selected = selected; }
	public void setNodes(ArrayList<GraphVertex> nodes) { this.nodes = nodes; }
	public void setEdges(ArrayList<GraphEdge> edges ) { this.edges = edges; }
	public float getAverageX() { return this.averageX; }
	public float getAverageY() { return this.averageY; }
	
	public void findSimilarNodes()
	{
		if ( nodes == null || edges == null ) { return; }
		
		for (GraphVertex node : nodes)
		{
			// if node type is similar, add
			similarNodes.add(node);
		}
	}
	*/
	
}
