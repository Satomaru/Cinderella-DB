
/**
 * undefinedまたはnullであることを判定する。
 *
 * @param {any} target
 * @returns {boolean}
 */
export const isNullish = target => target === undefined || target === null;

/**
 * 文字列に値を挿入する。
 *
 * @param {any} target      - 挿入先   (nullishの場合、挿入は行わない)
 * @param {number} position - 挿入位置 (0の場合は先頭に、-1の場合は末尾の前に挿入)
 * @param {any} value       - 挿入する値
 * @returns {string}
 */
export const insert = (target, position, value) => {
	if (isNullish(target)) {
		return target;
	}

	const dest = target.toString();
	const src = value.toString();
	const index = (position < 0) ? dest.length + position : position;

	if (index <= 0) {
		return src + dest;
	}

	if (index >= dest.length) {
		return dest + src;
	}

	return dest.slice(0, index) + src + dest.slice(index)
}
