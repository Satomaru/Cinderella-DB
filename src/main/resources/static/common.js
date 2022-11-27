const Common = {
	Eval: {
		isNullish: (target) => target === null || target === undefined
	},

	Element: {
		create: (name, spec) => {
			const element = document.createElement(name);

			if (spec) {
				for (let property in spec) {
					if (property === "children") {
						for (let child of spec.children) {
							if (!Common.Eval.isNullish(child)) {
								element.append(child);
							}
						}
					} else {
						element[property] = spec[property];
					}
				}
			}

			return element;
		}
	}
};
