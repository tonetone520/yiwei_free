package com.lineage.data.item_etcitem.mp;

import com.lineage.data.executor.ItemExecutor;
import com.lineage.server.model.Instance.L1ItemInstance;
import com.lineage.server.model.Instance.L1PcInstance;
import com.lineage.server.model.skill.L1BuffUtil;
import com.lineage.server.serverpackets.S_ServerMessage;

/**
 * 勇氣貨幣40735
 */
public class Mpr3 extends ItemExecutor {

	/**
	 *
	 */
	private Mpr3() {
		// TODO Auto-generated constructor stub
	}

	public static ItemExecutor get() {
		return new Mpr3();
	}

	/**
	 * 道具物件執行
	 * @param data 參數
	 * @param pc 執行者
	 * @param item 物件
	 */
	@Override
	public void execute(final int[] data, final L1PcInstance pc, final L1ItemInstance item) {
		// 例外狀況:物件為空
		if (item == null) {
			return;
		}
		// 例外狀況:人物為空
		if (pc == null) {
			return;
		}
		if (L1BuffUtil.stopPotion(pc)) {
			// 你的 %0%s 漸漸恢復。
			pc.sendPackets(new S_ServerMessage(338, "$1084"));
			pc.setCurrentMp(pc.getCurrentMp() + 60);
			pc.getInventory().removeItem(item, 1);
		}
	}
}