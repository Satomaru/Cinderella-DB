import {Tag, TagLoader} from "./classes/tag.js";

const resultsTab = Tag.find("resultsTab");
const trackList  = Tag.find("trackList");

const formatName = row => {
	const div = Tag.newDiv();
	Tag.newDiv("trackDisc").append(row.disc).into(div);
	Tag.newSpan("trackNo").append(row.track).into(div);
	Tag.newSpan().append(row.name).into(div);
	return div;
};

const formatIdols = row => row.idols.join("、");

export const build = json => {
	trackList.clear();

	json.forEach(row => TagLoader.loadTd(Tag.newTr())
		.load(formatName(row))
		.load(formatIdols(row))
		.into(trackList)
	);

	window.scrollTo(0, 0);
	resultsTab.element.click();
};
