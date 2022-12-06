import {Tag} from "./tag.js";

/** パラメータ。 */
export class Parameters {

	#properties = {};

	/**
	 * パラメータを作成する。
	 */
	constructor() {
	}

	/**
	 * パラメータを取得する。
	 *
	 * @param {string} key    - パラメータ名
	 * @param {number?} index - インデックス (省略時は0)
	 * @returns {(string | number | boolean)}
	 */
	get(key, index) {
		const values = this.#properties[key];
		return values ? values[index ?? 0] : undefined;
	}

	/**
	 * パラメータを設定する。
	 *
	 * @param {string} key                                - パラメータ名
	 * @param {(string | number | boolean)} initialValues - 初期値
	 */
	set(key, ...initialValues) {
		this.#properties[key] = initialValues;
	}

	/**
	 * パラメータを追加する。
	 *
	 * @param {string} key                            - パラメータ名
	 * @param {(string | number | boolean)} additions - 追加する値
	 */
	add(key, ...additions) {
		const values = this.#properties[key];

		if (values) {
			values.push(...additions);
		} else {
			this.set(key, ...additions);
		}
	}

	/**
	 * パラメータを除去する。
	 *
	 * @param {string} key - パラメータ名
	 */
	remove(key) {
		delete this.#properties[key];
	}

	/**
	 * タグからパラメータを取得する。
	 *
	 * @param {Tag} tag - フォーム要素タグ
	 */
	accept(tag) {
		if (tag.queriable) {
			this.add(tag.name, tag.value);
		}
	}

	/**
	 * クエリ文字列を作成する。
	 *
	 * @returns {string}
	 */
	createQuery() {
		const expressions = [];

		for (let key in this.#properties) {
			for (let value of this.#properties[key]) {
				const queryName = encodeURIComponent(key);
				const queryValue = encodeURIComponent(value);
				expressions.push(`${queryName}=${queryValue}`);
			}
		}

		return expressions.join("&");
	}
}
