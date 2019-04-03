package usf.dvl.mog.mapper.selection;

import usf.dvl.graph.layout.forcedirected.ForceDirectedLayoutVertex;

public class CoverPairwise extends usf.dvl.graph.layout.forcedirected.force.BasicForce.PairwiseForce {

	ForceDirectedLayoutVertex source;
	ForceDirectedLayoutVertex target;
	
	protected CoverPairwise(ForceDirectedLayoutVertex _node0, ForceDirectedLayoutVertex _node1) {
		super(_node0, _node1);
		// TODO Auto-generated constructor stub
		this.source = _node0;
		this.target = _node1;
		

	}

	@Override
	public void updateForce() {
		// TODO Auto-generated method stub

	}
	


}
