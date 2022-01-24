/*
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.com.example.study.intrinsics.CoroutineSingletons;
import kotlin.coroutines.com.example.study.intrinsics.IntrinsicsKt;
*/

/*public class SuspendBody {
    public static void main(String[] args) {
        label1:
        {
            label2:
            {
                label3:
                {
                    label4:
                    {
                        switch (continuation.label) {
                            Object result = continuation.result; //获取continuation里面的返回值
                            Object suspendLabel = IntrinsicsKt.getCOROUTINE_SUSPENDED();//获取挂起标签
                            case 0:
                                ResultKt.throwOnFailure(result);
                                continuation.label = 1;//更新label
                                if (suspendFun01(continuation) == suspendLabel) return;//如果在第一个挂起点被挂起了就直接返回
                                break;
                            case 1:
                                ResultKt.throwOnFailure(result);
                                break;
                            case 2:
                                ResultKt.throwOnFailure(result);
                                break label4;
                            case 3:
                                ResultKt.throwOnFailure(result);
                                break label3;
                            case 4:
                                ResultKt.throwOnFailure(result);
                                break label2;
                            case 5:
                                ResultKt.throwOnFailure(result);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                break ;
                        }
                        //如果没有被挂起继续执行
                        continuation.label = 2;
                        if (suspendFun02(continuation) == suspendLabel) return;//如果在第一个挂起点被挂起了就直接返回
                    }
                    continuation.label = 3;
                    if (suspendFun03(continuation) == suspendLabel) return;
                }
                continuation.label = 4;
                if (suspendFun04(continuation) == suspendLabel) return;
            }
            continuation.label = 5;
            if (suspendFun05(continuation) == suspendLabel) return;
        }
        continuation.label = 6;
        if (suspendFun06(continuation) == suspendLabel) return;

    }
}*/
