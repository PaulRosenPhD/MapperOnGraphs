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
		
//		System.out.println(super.mapperG.getNodeCount());
		for (int i = 0; i < super.mapperG.getNodeCount(); i++)
		{
			nodeSelection(i);
		}
		
//		if ( super.fdl.getSelectedPoint() >= 0 )
//		{
//			selected = (Mapper.MapperVertex)super.mapperG.nodes.get( super.fdl.getSelectedPoint() );
//
//			cc.clear();
//			cc.addAll( selected.cc );
//			this.SFD.cc = this.cc;
//
//			verts.clear();
//			ArrayList<ForceDirectedLayoutVertex> layoutverts = SFD.fdl.getLayoutVerts();
//
//			for ( GraphVertex g : cc)
//			{
//				try
//				{
//					verts.add(layoutverts.get( graph.getVertexIndex(g )) );
//				}
//				catch(Exception e) { e.printStackTrace(); }
//
//			}
//			this.SFD.verts = this.verts;
//
//			this.unmapX = PApplet.constrain( papplet.mouseX, super.fdl.getU0(), super.fdl.getU0() + super.fdl.getWidth() );
//			this.unmapY = PApplet.constrain( papplet.mouseY, super.fdl.getV0(), super.fdl.getV0() + super.fdl.getHeight() );
//
//
//			
//			this.SFD.unmapX = this.unmapX;   
//			this.SFD.unmapY = this.unmapY; 
//			
//			
//			// this gets min values, not the vertex position
////			super.fdl.getU0();
////			super.fdl.getV0();
////			super.fdl.getWidth();
////			super.fdl.getHeight();
//			
//			this.SFD._otheru0 = super.fdl.getU0();
//			this.SFD._otherv0 = super.fdl.getV0();
//			this.SFD._otherW = super.fdl.getU0() + super.fdl.getWidth();
//			this.SFD._otherH = super.fdl.getV0() + super.fdl.getHeight();
//			
//			
//			this.SFD.selectedPoint = super.fdl.getSelectedPoint();
//			
//		}
	}
	
	public void nodeSelection(int i)
	{
		selected = null;
		selected = (Mapper.MapperVertex)super.mapperG.nodes.get( i );
//		System.out.println(i);

		cc.clear();
		cc.addAll( selected.cc );
		this.SFD.cc = this.cc;

		verts.clear();
		ArrayList<ForceDirectedLayoutVertex> layoutverts = SFD.fdl.getLayoutVerts();

		for ( GraphVertex g : cc)
		{
			try
			{
				verts.add(layoutverts.get( graph.getVertexIndex(g )) );
			}
			catch(Exception e) { e.printStackTrace(); }

		}
		this.SFD.verts = this.verts;

		this.unmapX = PApplet.constrain( papplet.mouseX, super.fdl.getU0(), super.fdl.getU0() + super.fdl.getWidth() );
		this.unmapY = PApplet.constrain( papplet.mouseY, super.fdl.getV0(), super.fdl.getV0() + super.fdl.getHeight() );


		
		this.SFD.unmapX = this.unmapX;   
		this.SFD.unmapY = this.unmapY; 
		
		
		// this gets min values, not the vertex position
//		super.fdl.getU0();
//		super.fdl.getV0();
//		super.fdl.getWidth();
//		super.fdl.getHeight();
		
		this.SFD._otheru0 = super.fdl.getU0();
		this.SFD._otherv0 = super.fdl.getV0();
		this.SFD._otherW = super.fdl.getU0() + super.fdl.getWidth();
		this.SFD._otherH = super.fdl.getV0() + super.fdl.getHeight();
		
		
		this.SFD.selectedPoint = i;
//		this.selected = null;
	}
	
	@Override
	public void draw() { super.draw(); }
	
}
