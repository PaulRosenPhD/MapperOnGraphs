package usf.dvl.mog.mapper.selection;

import java.util.ArrayList;

import usf.dvl.graph.Graph;
import usf.dvl.graph.Graph.GraphEdge;
import usf.dvl.graph.Graph.GraphVertex;
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
	protected Set<GraphVertex> _cc = null;
	protected ArrayList<GraphVertex> cc = new ArrayList<GraphVertex>();
	protected SelectionForceDirected SFD = null;
	
	
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
			selected = (Mapper.MapperVertex)super.mapperG.nodes.get( super.fdl.getSelectedPoint() );
			_cc = selected.cc;
			
			if (selected == null) { System.out.println("oops"); }
//			ArrayList<GraphVertex> adj = (ArrayList<GraphVertex>)this.selected.getAdjacentVertices();
			
			// okay I guess this doesn't work
//			for (GraphVertex _v : _cc )
//			{
//				cc.add(_v);
//			}
			cc.clear();
			cc.addAll( _cc );
			 //for all, try and make a different color 
//			for (GraphVertex g : selected.cc)
//			{
//				if ( g != null)
//				{
//					this.cc.add(g);
//				}
//			}
//			graph.nodes = (ArrayList<GraphVertex>)selected.cc;
			
//			this.SFD.unmapX = papplet.mouseX;   /*super.fdl.unmapX(papplet.mouseX-u0);*/
//			this.SFD.unmapY = papplet.mouseY; /* super.fdl.unmapY(papplet.mouseY-v0); */
			this.SFD.unmapX =  super.fdl.unmapX(papplet.mouseX-u0);
			this.SFD.unmapY =  super.fdl.unmapY(papplet.mouseY-v0); 
			this.SFD._otheru0 = this.u0;
			this.SFD._otherv0 = this.v0;
			this.SFD._otherW = this.w;
			this.SFD._otherH = this.h;
			
			
			this.SFD.selectedPoint = super.fdl.getSelectedPoint();
			
			
			
		}
	}
	
	@Override
	public void draw()
	{
		super.draw();
		
//		for (GraphVertex v : _cc )
//		{
//			
//		}
	}
	
	/*
	public void setPosition( int _u0, int _v0, int _w, int _h)
	{
		super.setPosition(_u0, _v0, _w, _h);
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
