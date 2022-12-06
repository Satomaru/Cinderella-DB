import {Parameters} from "./parameters.js";

/** HTML要素の取り扱いをサポートする。 */
export class Tag {

	/**
	 * タグを作成する。
	 *
	 * @param {string} tagName - HTML要素名
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static create(tagName, ...classes) {
		return new Tag(document.createElement(tagName)).addClasses(...classes);
	}

	/**
	 * テーブル行タグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newTr(...classes) {
		return Tag.create("tr", ...classes);
	}

	/**
	 * テーブルデータタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newTd(...classes) {
		return Tag.create("td", ...classes);
	}

	/**
	 * ディビジョンタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newDiv(...classes) {
		return Tag.create("div", ...classes);
	}

	/**
	 * オーダーリストタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newOl(...classes) {
		return Tag.create("ol", ...classes);
	}

	/**
	 * アンオーダーリストタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newUl(...classes) {
		return Tag.create("ul", ...classes);
	}

	/**
	 * リストアイテムタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newLi(...classes) {
		return Tag.create("li", ...classes);
	}

	/**
	 * スパンタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newSpan(...classes) {
		return Tag.create("span", ...classes);
	}

	/**
	 * アンカータグを作成する。
	 *
	 * @param {string} url     - URL
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newAnchor(url, ...classes) {
		return Tag.create("a", ...classes).set("href", url);
	}

	/**
	 * ボタンタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newButton(...classes) {
		return Tag.create("button", ...classes).set("type", "button");
	}

	/**
	 * サブミットボタンタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newSubmit(...classes) {
		return Tag.create("button", ...classes).set("type", "submit");
	}

	/**
	 * Bootstrapアイコンタグを作成する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	static newIcon(...classes) {
		return Tag.create("i", ...classes);
	}

	/**
	 * 指定されたid属性値のHTML要素を検索して、タグを作成する。
	 *
	 * @param {string} id - id属性値
	 * @returns {Tag}
	 */
	static find(id) {
		return new Tag(document.getElementById(id));
	}

	/**
	 * タグに変換する。
	 *
	 * @param {(Tag | HTMLElement)} tagOrElement - タグ、またはHTML要素
	 * @returns {Tag}
	 */
	static of(tagOrElement) {
		if (tagOrElement instanceof Tag) {
			return tagOrElement;
		}

		return new Tag(tagOrElement);
	}

	/**
	 * HTML要素
	 *
	 * @type {HTMLElement}
	 */
	#element;

	/**
	 * タグを作成する。
	 *
	 * @param {HTMLElement} element - HTML要素
	 */
	constructor(element) {
		if (!(element instanceof HTMLElement)) {
			throw new "illegal argument.";
		}

		this.#element = element;
	}

	/**
	 * HTML要素。
	 *
	 * @type {HTMLElement}
	 */
	get element() {
		return this.#element;
	}

	/**
	 * タグ名。
	 *
	 * @type {string}
	 */
	get tag() {
		return this.element.tagName;
	}

	/**
	 * id属性値。
	 *
	 * @type {string}
	 */
	get id() {
		return this.element.id;
	}

	/**
	 * name属性値。
	 *
	 * @type {string}
	 */
	get name() {
		return this.element.name;
	}

	/**
	 * value属性値。
	 *
	 * @type {string}
	 */
	get value() {
		return this.element.value;
	}

	/**
	 * type属性値。
	 *
	 * @type {string}
	 */
	get type() {
		return this.element.type;
	}

	/**
	 * フォーム要素である場合はtrue。
	 *
	 * @type {boolean}
	 */
	get formItem() {
		return ["INPUT", "SELECT", "TEXTAREA"].includes(this.tag);
	}

	/**
	 * フォーム要素、かつチェック項目 (チェックボックス / ラジオボタン) である場合はtrue。
	 *
	 * @type {boolean}
	 */
	get checkable() {
		return this.tag === "INPUT" && ["checkbox", "radio"].includes(this.type);
	}

	/**
	 * フォーム要素、かつ現在クエリパラメータとして有効である場合はtrue。
	 *
	 * @type {boolean}
	 */
	get queriable() {
		if (!this.formItem) {
			return false;
		}

		if (this.element.disabled) {
			return false;
		}

		if (this.name === "") {
			return false;
		}

		return !this.checkable || this.element.checked;
	}

	/**
	 * 属性値を設定する。
	 *
	 * @param {string} name  - 属性名
	 * @param {string} value - 属性値
	 * @returns {Tag}
	 */
	set(name, value) {
		this.element[name] = value;
		return this;
	}

	/**
	 * クラスを追加する。
	 *
	 * @param {string} classes - クラス名
	 * @returns {Tag}
	 */
	addClasses(...classes) {
		classes.forEach(token => this.element.classList.add(...token.split(/\s+/)));
		return this;
	}

	/**
	 * 子要素を削除する。
	 *
	 * @returns {Tag}
	 */
	clear() {
		this.element.innerText = null;
		return this;
	}

	/**
	 * 子要素を追加する。
	 *
	 * @param {(string | Tag | HTMLElement | null)} textOrTagOrElements
	 * @returns {Tag}
	 */
	append(...textOrTagOrElements) {
		textOrTagOrElements.forEach(child => {
			if (child instanceof Tag) {
				this.element.append(child.element);
			} else if (child !== null) {
				this.element.append(child);
			}
		});

		return this;
	}

	/**
	 * 引数で指定された要素に、子要素としてこのタグを追加する。
	 *
	 * @param {(Tag | HTMLElement)} tagOrElement - タグ、またはHTML要素
	 * @returns {Tag}
	 */
	into(tagOrElement) {
		Tag.of(tagOrElement).append(this);
		return this;
	}

	/**
	 * イベントリスナーを登録する。
	 *
	 * @param {string} eventName       - イベント名
	 * @param {Function} eventAcceptor - イベント処理関数
	 * @returns {Tag}
	 */
	listen(eventName, eventAcceptor) {
		this.element.addEventListener(eventName, eventAcceptor);
		return this;
	}

	/**
	 * フォーム要素、かつ現在クエリパラメータとして有効である子要素を抽出し、パラメータを作成する。
	 *
	 * @returns {Parameters}
	 */
	extractParameters() {
		const parameters = new Parameters();

		[...this.element.querySelectorAll("input, select, textarea")]
			.map(element => Tag.of(element))
			.filter(tag => tag.queriable)
			.forEach(tag => parameters.accept(tag));

		return parameters;
	}
}

/** 同じタグ名の子要素を、繰り返し装填する。 */
export class TagLoader {

	/**
	 * TRタグを作成して、繰り返しTDタグを装填する。
	 *
	 * @param {string} classes - TDタグのクラス名
	 * @returns {TagLoader}
	 */
	static newTr(...classes) {
		return new TagLoader(Tag.newTr(), () => Tag.newTd(...classes));
	}

	/**
	 * OLタグを作成して、繰り返しLIタグを装填する。
	 *
	 * @param {string} classes - LIタグのクラス名
	 * @returns {TagLoader}
	 */
	static newOl(...classes) {
		return new TagLoader(Tag.newOl(), () => Tag.newLi(...classes));
	}

	/**
	 * ULタグを作成して、繰り返しLIタグを装填する。
	 *
	 * @param {string} classes - LIタグのクラス名
	 * @returns {TagLoader}
	 */
	static newUl(...liClasses) {
		return new TagLoader(Tag.newUl(), () => Tag.newLi(...liClasses));
	}

	/**
	 * 子要素を装填するタグ。
	 *
	 * @type {Tag}
	 */
	#self;

	/**
	 * 子要素を生成する関数。
	 *
	 * @type {() => Tag}
	 */
	#generator;

	/**
	 * タグローダーを作成する。
	 *
	 * @param {Tag} self            - 子要素を装填するタグ
	 * @param {() => Tag} generator - 子要素を生成する関数
	 */
	constructor(self, generator) {
		this.#self = self;
		this.#generator = generator;
	}

	/**
	 * 子要素を装填するタグ。
	 *
	 * @type {Tag}
	 */
	get self() {
		return this.#self;
	}

	/**
	 * 子要素を装填する。
	 *
	 * @param {(string | Tag | HTMLElement | null)} content - 装填する子要素の内容
	 * @returns {TagLoader}
	 */
	load(content) {
		this.#generator().append(content).into(this.self);
		return this;
	}

	/**
	 * 引数で指定された要素に、子要素としてこのタグを追加する。
	 *
	 * @param {(Tag | HTMLElement)} parent - タグ、またはHTML要素
	 * @returns {TagLoader}
	 */
	into(parent) {
		this.self.into(parent);
		return this;
	}
}
